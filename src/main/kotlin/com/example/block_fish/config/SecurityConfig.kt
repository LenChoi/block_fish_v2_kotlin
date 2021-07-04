package com.example.block_fish.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig @Autowired constructor(
    val userAuthenticationProvider: UserAuthenticationProvider
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.run {
            cors {}
            csrf { it.disable() }
            authorizeRequests {
                it.anyRequest().permitAll()
            }
            httpBasic {}
            formLogin { it.disable() }
        }
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(userAuthenticationProvider)
    }

}