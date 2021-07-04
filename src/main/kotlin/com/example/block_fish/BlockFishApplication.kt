package com.example.block_fish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class BlockFishApplication

fun main(args: Array<String>) {
    runApplication<BlockFishApplication>(*args)
}
