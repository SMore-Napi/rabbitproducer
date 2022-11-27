package ru.innopolis.rabbitproducer

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class RabbitMqProducer(
    private val template: AmqpTemplate
) {
    @Value("\${rabbit.queueName}")
    private val queueName: String? = null

    @PostMapping("/publish")
    fun sendMessage(): ResponseEntity<String> {
        val message = generateMessage()
        template.convertAndSend(queueName, message)
        println("Sent message=$message")
        return ResponseEntity.ok("Sent message=$message")
    }

    private fun generateMessage(): String {
        val gender = when (Random.nextInt(0, 2)) {
            0 -> Gender.FEMALE
            else -> Gender.MALE
        }
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z')
        val name = List(6) { charPool.random() }.joinToString("")
        return MessageDto(gender, name).toString()
    }
}
