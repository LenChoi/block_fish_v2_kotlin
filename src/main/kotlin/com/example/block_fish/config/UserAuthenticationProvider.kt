package com.example.block_fish.config

import com.example.block_fish.file.service.UserService
import com.example.block_fish.user.support.exception.BlockFishException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class UserAuthenticationProvider(
    val userService: UserService
) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val email: String = authentication.name
        val plainPassword: String = authentication.credentials.toString()

        try {
            val user = userService.login(email, plainPassword)

            val userPrincipal = UserPrincipal(user.id!!, user.email, user.status, user.name)

            return UsernamePasswordAuthenticationToken(userPrincipal, null, mutableListOf())
        } catch (e: BlockFishException) {
            throw BadCredentialsException(e.messageKey, e)
        }
    }

    override fun supports(authentication: Class<*>?) = authentication == UsernamePasswordAuthenticationToken::class.java
}
