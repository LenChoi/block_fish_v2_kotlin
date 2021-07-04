package com.example.block_fish.file.controller

import com.example.block_fish.config.UserPrincipal
import com.example.block_fish.file.dto.LoginRes
import com.example.block_fish.file.service.UserService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

@RestController
@RequestMapping("/user")
class UserApi(
    val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody req: CreateUserReq) {
        userService.create(req.email, req.password, req.password)
    }

    @PostMapping("/login")
    fun login(session: HttpSession): LoginRes {
        println("session = ${session.id}")
        val user = SecurityContextHolder.getContext().authentication.principal as UserPrincipal
        println("user.email = ${user.email}")
        return LoginRes(session.id, SecurityContextHolder.getContext().authentication.principal as UserPrincipal)
    }
}