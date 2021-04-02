package wooyoung.tom.simplespringboot.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.user.dto.MarketUserSigningRequest
import wooyoung.tom.simplespringboot.user.dto.MarketUserSignUpResponse

@Service
open class MarketUserService(
    private val marketUserRepository: MarketUserRepository
) {

    // 회원가입
    @Transactional
    open fun signUp(user: MarketUserSigningRequest): MarketUserSignUpResponse {
        // 유저 이름 중복되는지 확인한다.
        // foundUser null, non-null 판단
        when (marketUserRepository.findMarketUserByUserName(user.name)) {
            null -> {
                // null 이면 가입 가능 -> save 진행
                val newUser = MarketUserEntity(
                    userName = user.name,
                    password = user.password
                )

                try {
                    marketUserRepository.save(newUser)
                } catch (npe: NullPointerException) {
                    return MarketUserSignUpResponse(
                        code = "Failed",
                        message = "${npe.message}"
                    )
                }
            }
            else -> {
                return MarketUserSignUpResponse(
                    code = "Duplicated",
                    message = "이미 존재하는 유저이름입니다."
                )
            }
        }

        return MarketUserSignUpResponse(
            code = "Success",
            message = "회원가입에 성공하였습니다."
        )
    }
}