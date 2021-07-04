package com.example.block_fish.user.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

interface UserPasswordEncryptor {
    fun encrypt(plainPassword: String): String

    fun check(plainPassword: String, encryptedPassword: String): Boolean
}

@Component
class SpringSecurityPasswordEncryptor @Autowired constructor(
    val passwordEncoder: PasswordEncoder
) : UserPasswordEncryptor{
    override fun encrypt(plainPassword: String): String = passwordEncoder.encode(plainPassword)

    override fun check(plainPassword: String, encryptedPassword: String): Boolean =
        passwordEncoder.matches(plainPassword, encryptedPassword)
}