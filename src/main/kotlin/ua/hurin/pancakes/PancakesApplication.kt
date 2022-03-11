package ua.hurin.pancakes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PancakesApplication

fun main(args: Array<String>) {
    runApplication<PancakesApplication>(*args)
}

