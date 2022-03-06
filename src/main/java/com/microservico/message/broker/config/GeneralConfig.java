package com.microservico.message.broker.config;

import com.microservico.message.broker.camel.CamelContextWrapper;
import com.microservico.message.broker.camel.router.SendEstoqueRouter;
import com.microservico.message.broker.repository.CamelRepository;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {

    @Bean
    public CamelContextWrapper camelContextWrapper(RouteBuilder... routes) throws Exception {
        return new CamelContextWrapper(routes);
    }

    @Bean
    public SendEstoqueRouter sendEstoqueRouter(CamelRepository camelRepository) {
        return new SendEstoqueRouter(camelRepository);
    }

}
