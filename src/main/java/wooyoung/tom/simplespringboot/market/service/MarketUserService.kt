package wooyoung.tom.simplespringboot.market.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignInRequest
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignInResponse
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignUpRequest
import wooyoung.tom.simplespringboot.market.dto.user.MarketUserSignUpResponse
import wooyoung.tom.simplespringboot.market.entity.MarketUser
import wooyoung.tom.simplespringboot.market.repository.MarketUserRepository

@Service
open class MarketUserService(
    private val marketUserRepository: MarketUserRepository
) {

    @Transactional
    open fun signUp(marketUserSignUpRequest: MarketUserSignUpRequest): MarketUserSignUpResponse {
        val newUser = MarketUser(
            name = marketUserSignUpRequest.name,
            password = marketUserSignUpRequest.password
        )

        // 먼저 중복된 이름 있는지 확인
        val foundUser = marketUserRepository.findMarketUserByName(newUser.name)

        if (foundUser == null) {
            val saveResult = marketUserRepository.save(newUser)

            return if (saveResult.id == null) {
                MarketUserSignUpResponse("FAILED")
            } else {
                MarketUserSignUpResponse(code = "SUCCESS")
            }
        } else {
            return MarketUserSignUpResponse(code = "DUPLICATED")
        }
    }

    open fun simpleSignIn(marketUserSignInRequest: MarketUserSignInRequest): MarketUserSignInResponse {
        val foundUser = marketUserRepository.findMarketUserByName(marketUserSignInRequest.name)

        if (foundUser == null) {
            return MarketUserSignInResponse(
                code = "NAME FAILED",
                body = null
            )
        } else {
            val checkPassword = foundUser.password == marketUserSignInRequest.password

            return if (checkPassword) {
                MarketUserSignInResponse(
                    code = "SUCCESS",
                    body = foundUser
                )
            } else {
                MarketUserSignInResponse(
                    code = "PASSWORD FAILED",
                    body = null
                )
            }
        }
    }
}