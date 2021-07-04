package com.example.block_fish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession

@EnableJpaAuditing
@SpringBootApplication
@EnableSpringHttpSession
class BlockFishApplication

fun main(args: Array<String>) {
    runApplication<BlockFishApplication>(*args)
}
