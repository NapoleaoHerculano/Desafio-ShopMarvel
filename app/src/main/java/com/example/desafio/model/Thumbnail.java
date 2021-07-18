package com.example.desafio.model;

/**
 * Objeto que faz parte da requisição a API.
 * Utilizado para recuperar o caminho da imagem.
 */
public class Thumbnail {

    private String path;
    private String extension;

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
