package com.microservices.template.shared.adapters.Emitter;

import com.microservices.template.shared.contracts.Emitter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.nio.charset.StandardCharsets;

public class RabbitMQEmitter implements Emitter {

    @Override
    public void sendMessage(String channel, String event) {
        Message messageJson = MessageBuilder.withBody(event.getBytes(StandardCharsets.UTF_8))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();

        AmqpTemplate template = getTemplate(channel);

        template.convertAndSend(channel, messageJson);
    }

    private AmqpTemplate getTemplate(String channel) {
        ConnectionFactory connectionFactory = new CachingConnectionFactory();
        AmqpAdmin admin = new RabbitAdmin(connectionFactory);
        admin.declareQueue(new Queue(channel));
        return new RabbitTemplate(connectionFactory);
    }
}
