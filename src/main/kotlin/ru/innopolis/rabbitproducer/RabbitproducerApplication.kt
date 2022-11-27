package ru.innopolis.rabbitproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.concurrent.thread

@SpringBootApplication
class RabbitproducerApplication

fun main(args: Array<String>) {
	val context = runApplication<RabbitproducerApplication>(*args)
    thread(start = true) {
        Thread.sleep(1000)
        while (true) {
            val producer = context.getBean("rabbitMqProducer") as RabbitMqProducer
            producer.sendMessage()
            Thread.sleep(2000)
        }
    }
}
