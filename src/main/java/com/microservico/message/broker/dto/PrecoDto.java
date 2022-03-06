package com.microservico.message.broker.dto;

import java.io.Serializable;

public class PrecoDto implements Serializable {
    public long codigoproduto;
    public double preco;

    public PrecoDto() {
    }

    public PrecoDto(long codigoproduto, double preco) {
        this.codigoproduto = codigoproduto;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "PrecoDto{" +
                "codigoproduto='" + codigoproduto + '\'' +
                ", preco=" + preco +
                '}';
    }
}
