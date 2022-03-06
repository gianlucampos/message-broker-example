package com.microservico.message.broker.camel.router;

import com.microservico.message.broker.camel.processor.ExpensivePrecoProcessor;
import com.microservico.message.broker.dto.PrecoDto;
import com.microservico.message.broker.repository.CamelRepository;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class SendEstoqueRouter extends RouteBuilder {

    public static final String SEND_ESTOQUE = "direct:sendEstoque";

    private final CamelRepository camelRepository;

    public SendEstoqueRouter(CamelRepository camelRepository) {
        this.camelRepository = camelRepository;
    }

    @Override
    public void configure() {
        from(SEND_ESTOQUE)
                .routeId("SEND_STOQUE")
                .log("${body}")
                .bean(camelRepository, "makePrecoByEstoque(${body})")
                .log("${body}")
                .choice()
                    .when(this::isExpensive)
//                        .process(exchange -> exchange.getIn().setBody("Está caro o produto"))
                        .log("Está caro o produto, dividindo o valor pela metade")
                        .process(new ExpensivePrecoProcessor())
                    .otherwise()
                        .log("Não está caro o produto")
                .end();
    }

    private Boolean isExpensive(Exchange exchange) {
        var body = (PrecoDto) exchange.getIn().getBody();
        return body.preco > 5.0;
    }


}
