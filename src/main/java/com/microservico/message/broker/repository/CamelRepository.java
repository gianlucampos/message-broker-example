package com.microservico.message.broker.repository;

import com.microservico.message.broker.dto.EstoqueDto;
import com.microservico.message.broker.dto.PrecoDto;

public interface CamelRepository {

    PrecoDto makePrecoByEstoque(EstoqueDto estoqueDto);

}
