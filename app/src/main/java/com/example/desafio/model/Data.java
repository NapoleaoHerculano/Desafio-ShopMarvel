package com.example.desafio.model;

import java.util.List;

/**
 * Objeto que faz parte da requisição a API.
 */
public class Data {

    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private List<Comic> results;

    public Data(Integer offset, Integer limit, Integer total, Integer count, List<Comic> results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Comic> getResults() {
        return results;
    }

    public void setResults(List<Comic> results) {
        this.results = results;
    }
}
