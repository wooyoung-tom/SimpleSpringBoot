package wooyoung.tom.simplespringboot.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.dto.CommonSimpleResponse
import wooyoung.tom.simplespringboot.user.dto.MarketUserSignInResponse
import wooyoung.tom.simplespringboot.user.dto.MarketUserSigningRequest
import wooyoung.tom.simplespringboot.user.dto.MarketUserSigningDTO

@Service
open class MarketUserService(
    private val marketUserRepository: MarketUserRepository
) {

    // 회원가입
    @Transactional
    open fun signUp(user: MarketUserSigningRequest): CommonSimpleResponse {
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
                    return CommonSimpleResponse(
                        code = "Failed",
                        message = "${npe.message}"
                    )
                }
            }
            else -> {
                return CommonSimpleResponse(
                    code = "Duplicated",
                    message = "이미 존재하는 유저이름입니다."
                )
            }
        }

        return CommonSimpleResponse(
            code = "Success",
            message = "회원가입에 성공하였습니다."
        )
    }

    // 로그인
    open fun signIn(user: MarketUserSigningRequest): MarketUserSignInResponse {
        // 받아온 정보로 유저가 있는지 확인한다.
        return when (val result = marketUserRepository.findMarketUserByUserName(user.name)) {
            null -> {
                // null 이면 유저 정보를 찾지 못한 것
                return MarketUserSignInResponse(
                    code = "NotFound",
                    message = "해당 유저가 존재하지 않습니다."
                )
            }
            else -> {
                // 유저 찾은 것 password 비교
                if (user.password == result.password) {
                    MarketUserSignInResponse(
                        code = "Success",
                        message = "로그인에 성공하였습니다.",
                        user = MarketUserSigningDTO(result.id, result.userName)
                    )
                } else {
                    MarketUserSignInResponse(
                        code = "Failed",
                        message = "비밀번호가 일치하지 않습니다."
                    )
                }
            }
        }
    }
}