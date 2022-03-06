package com.microservico.message.broker.repository.impl;

import com.microservico.message.broker.dto.EstoqueDto;
import com.microservico.message.broker.dto.PrecoDto;
import com.microservico.message.broker.repository.CamelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CamelRepositoryImpl implements CamelRepository {

    @Override
    public PrecoDto makePrecoByEstoque(EstoqueDto estoqueDto) {
        return new PrecoDto(estoqueDto.codigoProduto, estoqueDto.quantidade * 2);
    }
}
