package com.example.block_fish.config

import com.example.block_fish.user.domain.UserStatus

data class UserPrincipal(
    val id: Long,
    val email: String,
    val status: UserStatus,
    val name: String
)