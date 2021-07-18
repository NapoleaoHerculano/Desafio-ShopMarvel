package com.example.desafio.model;

/**
 * Objeto que faz parte da requisição a API.
 * Utilizado para guardar o preço do quadrinho.
 */
public class Price {
    private String type;
    private Double price;

    public Price(String type, Double price) {
        this.type = type;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
