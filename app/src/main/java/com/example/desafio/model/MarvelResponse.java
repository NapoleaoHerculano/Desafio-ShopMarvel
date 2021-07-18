package com.example.desafio.model;

/**
 * Objeto que faz parte da requisição a API.
 */
public class MarvelResponse {
    private Integer code;
    private String status;
    private Data data;

    public MarvelResponse(Integer code, String status, Data data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
