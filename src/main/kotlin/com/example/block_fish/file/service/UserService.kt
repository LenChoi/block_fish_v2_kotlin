package com.example.block_fish.file.service

import com.example.block_fish.user.domain.User
import com.example.block_fish.user.domain.UserPasswordEncryptor
import com.example.block_fish.user.domain.UserRepository
import com.example.block_fish.user.support.exception.BlockFishException
import com.example.block_fish.user.support.exception.BlockFishException.Companion.USER_NOT_FOUND
import org.springframework.stereotype.Service
import javax.transaction.Transactional

interface UserService {
    fun create(email: String, password: String, name: String)
    fun login(email: String, plainPassword: String): User
}

@Service
@Transactional
class UserServiceImpl(
    val userRepository: UserRepository,
    val userPasswordEncryptor: UserPasswordEncryptor
) : UserService {
    override fun create(email: String, password: String, name: String) {
        if (userRepository.findByEmail(email) != null) throw BlockFishException(USER_NOT_FOUND)

        var user = User.create(email, password, userPasswordEncryptor, name)
        user = userRepository.save(user)
    }

    override fun login(email: String, plainPassword: String): User {
        return userRepository.findByEmail(email)!!.run {
            login(plainPassword, userPasswordEncryptor)
        }
    }
}