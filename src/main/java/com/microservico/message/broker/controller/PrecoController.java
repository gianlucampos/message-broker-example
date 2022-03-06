package com.microservico.message.broker.controller;

import com.microservico.message.broker.dto.PrecoDto;
import com.microservico.message.broker.service.RabbitMQService;
import com.microservico.message.broker.util.RabbitMQConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "preco")
public class PrecoController {

    private final RabbitMQService rabbitmqService;

    public PrecoController(RabbitMQService rabbitmqService) {
        this.rabbitmqService = rabbitmqService;
    }

    @PutMapping
    private ResponseEntity<?> alteraPreco(@RequestBody PrecoDto precoDto) {
        this.rabbitmqService.enviaMensagem(RabbitMQConstants.FILA_PRECO, precoDto);
        return ResponseEntity.ok().build();
    }
}
