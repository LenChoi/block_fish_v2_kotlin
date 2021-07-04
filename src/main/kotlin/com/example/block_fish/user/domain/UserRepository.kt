package com.example.block_fish.user.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>{
    fun findByEmail(email: String): User?
}