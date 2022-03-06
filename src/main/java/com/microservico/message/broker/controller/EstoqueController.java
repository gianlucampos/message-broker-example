package com.microservico.message.broker.controller;

import com.microservico.message.broker.dto.EstoqueDto;
import com.microservico.message.broker.service.RabbitMQService;
import com.microservico.message.broker.util.RabbitMQConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {

    private final RabbitMQService rabbitmqService;

    public EstoqueController(RabbitMQService rabbitmqService) {
        this.rabbitmqService = rabbitmqService;
    }

    @PutMapping
    private ResponseEntity<?> alteraEstoque(@RequestBody EstoqueDto estoqueDto) {
        System.out.println(estoqueDto);
        this.rabbitmqService.enviaMensagem(RabbitMQConstants.FILA_ESTOQUE, estoqueDto);
        return ResponseEntity.ok().build();
    }
}
