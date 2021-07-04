package com.example.block_fish.file.dto

import com.example.block_fish.config.UserPrincipal
import com.example.block_fish.user.domain.UserStatus

class LoginRes(
    val sessionId: String,

    val id: Long,
    val email: String,
    val name: String,
    val status: UserStatus
) {
    constructor(sessionId: String, user: UserPrincipal): this(sessionId, user.id, user.email, user.name, user.status)
}
