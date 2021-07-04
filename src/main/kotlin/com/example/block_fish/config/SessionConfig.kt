package com.example.block_fish.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.MapSessionRepository
import org.springframework.session.web.http.HeaderHttpSessionIdResolver

@Configuration
class SessionConfig {
    val maxInactiveIntervalInSeconds = 60 * 20  // 20 mins

    @Bean
    fun mapSessionRepository(): MapSessionRepository {
        val sessionRepository = MapSessionRepository(mutableMapOf())
        sessionRepository.setDefaultMaxInactiveInterval(maxInactiveIntervalInSeconds)
        return sessionRepository
    }

    @Bean
    fun sessionStrategy(): HeaderHttpSessionIdResolver {
        return HeaderHttpSessionIdResolver.xAuthToken()
    }
}