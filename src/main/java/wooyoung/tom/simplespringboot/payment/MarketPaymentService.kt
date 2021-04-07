package wooyoung.tom.simplespringboot.payment

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.order.MarketOrderRepository
import wooyoung.tom.simplespringboot.order.dto.MarketOrderIncludingDetails
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentLaterItem
import wooyoung.tom.simplespringboot.payment.dto.MarketPaymentLaterResponse

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
}
