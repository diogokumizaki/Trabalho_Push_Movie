package com.mycompany.bibliotecafilmes.model;

public class Filme {
    
    private String titulo;
    private String anoLançamento;
    private String imdbID;

    public Filme(String titulo, String anoLançamento, String imdbID) {
        this.titulo = titulo;
        this.anoLançamento = anoLançamento;
        this.imdbID = imdbID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoLançamento() {
        return anoLançamento;
    }

    public void setAnoLançamento(String anoLançamento) {
        this.anoLançamento = anoLançamento;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
