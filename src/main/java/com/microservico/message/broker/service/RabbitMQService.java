package com.microservico.message.broker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public RabbitMQService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void enviaMensagem(String nomeFila, Object mensagem) {
        try {
            String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
            this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
