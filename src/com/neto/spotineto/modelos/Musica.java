package com.neto.spotineto.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Musica extends Audio{
    private List<String> generos;
    private List<String> gravadoras;


    public Musica(MusicaResponse resultado) {
        super(resultado.title(), Integer.valueOf(resultado.year()), resultado.cover_image());
        this.generos = resultado.genre();
        this.gravadoras = resultado.label();
    }

    public List<String> getGeneros() {
        return generos;
    }

    public List<String> getGravadoras() {
        return gravadoras;
    }

    @Override
    public String toString() {
        return this.getTitulo() + "\nAno de Lançamento: " + this.getAnoDeLancamento() + "\nGêneros: " + this.getGeneros()
                + "\nGravadora: " + this.getGravadoras() + "\nURL para imagem da capa: " + this.getImagemURL();
    }
}
