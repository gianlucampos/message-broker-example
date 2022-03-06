package com.microservico.message.broker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservico.message.broker.camel.CamelContextWrapper;
import com.microservico.message.broker.camel.router.SendEstoqueRouter;
import com.microservico.message.broker.dto.EstoqueDto;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CamelService {

    private final ProducerTemplate template;

    public CamelService(CamelContextWrapper wrapper) {
        this.template = wrapper.createProducerTemplate();
    }

    public void sendEstoque(EstoqueDto estoqueDto) {
        var body = template.requestBody(SendEstoqueRouter.SEND_ESTOQUE, estoqueDto);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

}
