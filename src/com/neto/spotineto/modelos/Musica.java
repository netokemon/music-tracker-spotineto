package com.neto.spotineto.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Musica extends Audio{
    @SerializedName("genre")
    private List<String> generos;
    private String album;
    private String gravadora;

    public Musica(String titulo, String artista, int duracaoEmSegundos, String genero) {
        super(titulo, artista, duracaoEmSegundos);
        this.generos = generos;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public String getAlbum() {
        return album;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }
}
