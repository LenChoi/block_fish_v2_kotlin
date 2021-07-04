package com.example.block_fish.user.domain

import com.example.block_fish.user.support.exception.BlockFishException
import com.example.block_fish.user.support.exception.BlockFishException.Companion.LOCKED_USER
import com.example.block_fish.user.support.exception.BlockFishException.Companion.LOGIN_FAIL
import com.example.block_fish.user.support.jpa.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated

@Entity
class User(
     @Column(length = 50, nullable = false)
     var email: String,

     @Column(nullable = false)
     var passwordEncrypted: String,

     @Column(length = 50, nullable = false)
     var name: String,

     @Enumerated
     var status: UserStatus = UserStatus.CREATED,
): BaseEntity() {

     fun login(plainPassword: String, encryptedPassword: UserPasswordEncryptor): User{
          checkStatus()

          if (encryptedPassword.check(plainPassword, this.passwordEncrypted)) {
               return this
          }

          throw BlockFishException(LOGIN_FAIL)
     }

     fun checkStatus() {
          if (this.status == UserStatus.HOLD || this.status == UserStatus.INACTIVE) {
               throw BlockFishException(LOCKED_USER)
          }
     }
     companion object {
          fun create(
               email: String,
               plainPassword: String,
               userPasswordEncryptor: UserPasswordEncryptor,
               name: String
          ): User {
               val user =  User(email, userPasswordEncryptor.encrypt(plainPassword), name)
               return user
          }
     }
}