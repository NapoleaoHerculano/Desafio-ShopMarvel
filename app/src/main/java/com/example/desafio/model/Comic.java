package com.example.desafio.model;


import java.io.Serializable;
import java.util.List;

/**
 * Classe que representa o objeto referente ao quadrinho vindo da requisição.
 */
public class Comic implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private List<Price> prices;
    private Thumbnail thumbnail;
    private boolean isRare;

    public Comic(Integer id, String title, String description, List<Price> prices, Thumbnail thumbnail, boolean isRare) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prices = prices;
        this.thumbnail = thumbnail;
        this.isRare = isRare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isRare() {
        return isRare;
    }

    public void setRare(boolean rare) {
        isRare = rare;
    }
}
