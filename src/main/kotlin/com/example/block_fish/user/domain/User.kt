package com.example.block_fish.user.domain

import com.example.block_fish.user.support.jpa.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated

@Entity
class User(
     @Column(length = 50, nullable = false)
     var email: String,

     @Column(nullable = false)
     var password: String,

     @Column(length = 50, nullable = false)
     var name: String,

     @Enumerated
     var status: UserStatus = UserStatus.CREATED,
): BaseEntity()