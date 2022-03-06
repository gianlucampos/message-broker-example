package com.microservico.message.broker.dto;

import java.io.Serializable;

public class EstoqueDto implements Serializable {
    public long codigoProduto;
    public int quantidade;

    @Override
    public String toString() {
        return "EstoqueDto{" +
                "codigoproduto='" + codigoProduto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
