package com.microservico.message.broker.camel.processor;

import com.microservico.message.broker.dto.PrecoDto;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExpensivePrecoProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        var preco = exchange.getIn().getBody(PrecoDto.class);
        preco.preco = preco.preco / 2;
        exchange.getIn().setBody(preco);
    }


}
