package wooyoung.tom.simplespringboot.payment

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.CommonSimpleResponse
import wooyoung.tom.simplespringboot.order.MarketOrderRepository
import wooyoung.tom.simplespringboot.order.dto.MarketOrderIncludingDetails
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentLaterItem
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentLaterResponse
import java.time.LocalDateTime

@Service
open class MarketPaymentService(
    private val marketPaymentRepository: MarketPaymentRepository,
    private val marketOrderRepository: MarketOrderRepository
) {

    @Transactional
    open fun findNotPaidPayment(userId: Long): MarketPaymentLaterResponse {
        // 나중결제 처리된 오더리스트 먼저 가지고오기
        val orders = marketOrderRepository
            .findAllByUserIdAndOrderStatus(userId, "Later")

        // 결제 id 리스트 생성
        val paymentIds = orders.groupBy { it.paymentId ?: 0 }.keys.toList()

        // 결제 item list (Datetime 오름차순)
        val paymentItems = marketPaymentRepository.findAllByIdInOrderByDatetimeAsc(paymentIds)

        val paymentList = paymentItems.map {
            MarketPaymentLaterItem(
                id = it.id,
                method = it.method,
                status = it.status,
                datetime = it.datetime,
                orderItems = it.orderItems.map { order ->
                    MarketOrderIncludingDetails(
                        orderId = order.id,
                        restaurant = order.restaurant,
                        totalPrice = order.orderDetailList.sumOf { orderDetail ->
                            (orderDetail.menu.price * orderDetail.menuCount)
                        },
                        orderDetailList = order.orderDetailList
                    )
                }
            )
        }

        return when (paymentItems.isEmpty()) {
            true -> {
                MarketPaymentLaterResponse(
                    code = "Empty",
                    message = "결제 대기중인 주문이 없습니다.",
                    paymentList = paymentList
                )
            }
            false -> {
                MarketPaymentLaterResponse(
                    code = "Success",
                    message = "결제 대기중인 주문이 ${paymentItems.size}건 존재합니다.",
                    paymentList = paymentList
                )
            }
        }
    }

    @Transactional
    open fun cancelPayment(paymentId: Long): CommonSimpleResponse {
        // 새로 취소된 결제 하나 생성
        val canceledPayment = MarketPaymentEntity(
            method = "취소된 결제",
            status = "Canceled",
            datetime = LocalDateTime.now()
        )

        // 취소된 결제 저장
        try {
            marketPaymentRepository.save(canceledPayment)
        } catch (e: IllegalArgumentException) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "결제 정보 저장에 실패했습니다."
            )
        }

        // 결제 id 통해서 오더 리스트 조회
        val orders = marketOrderRepository.findAllByPaymentId(paymentId)

        if (orders.isEmpty()) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "조회된 오더가 존재하지 않습니다."
            )
        }

        // 취소된 결제로 id 수정 및 준비상태로 rollback
        orders.forEach { order ->
            order.paymentId = canceledPayment.id
            order.orderStatus = "Ready"
        }

        // 오더 상태 update
        try {
            marketOrderRepository.saveAll(orders)
        } catch (e: IllegalArgumentException) {
            return CommonSimpleResponse(
                code = "Failed",
                message = "오더 정보 갱신에 실패했습니다."
            )
        }

        return CommonSimpleResponse(
            code = "Success",
            message = "결제 취소를 완료하였습니다."
        )
    }
}
