package com.microservico.message.broker.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservico.message.broker.dto.EstoqueDto;
import com.microservico.message.broker.service.CamelService;
import com.microservico.message.broker.util.RabbitMQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    private final CamelService camelService;

    public EstoqueConsumer(CamelService camelService) {
        this.camelService = camelService;
    }

    @RabbitListener(queues = RabbitMQConstants.FILA_ESTOQUE)
    private void consumidor(String mensagem) throws JsonProcessingException {
        EstoqueDto estoqueDto = new ObjectMapper().readValue(mensagem, EstoqueDto.class);
        System.out.println(estoqueDto);
        System.out.println("------------------------------------");
        camelService.sendEstoque(estoqueDto);
    }

}
