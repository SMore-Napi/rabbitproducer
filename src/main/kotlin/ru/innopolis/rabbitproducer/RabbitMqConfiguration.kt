package ru.innopolis.rabbitproducer

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfiguration {

    @Value("\${rabbit.queueName}")
    private val queueName: String? = null

    @Value("\${rabbit.host}")
    private val host: String? = null

    @Bean
    fun connectionFactory(): ConnectionFactory = CachingConnectionFactory(host)

    @Bean
    fun amqpAdmin(): AmqpAdmin = RabbitAdmin(connectionFactory())

    @Bean
    fun rabbitTemplate(): RabbitTemplate = RabbitTemplate(connectionFactory())

    @Bean
    fun myQueue(): Queue = Queue(queueName)
}
