package wooyoung.tom.simplespringboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SimpleSpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(SimpleSpringBootApplication::class.java, *args)
}