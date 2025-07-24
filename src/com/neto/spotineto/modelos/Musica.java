package com.neto.spotineto.modelos;

import java.util.List;

public class Musica{
    private String titulo;
    private String imagemURL;
    private int anoDeLancamento;
    private List<String> generos;
    private List<String> gravadoras;


    public Musica(MusicaResponse resultado) {
        this.titulo = resultado.title();
        try{
            this.anoDeLancamento = Integer.parseInt(resultado.year());
        } catch(NumberFormatException e){
            this.anoDeLancamento = 0;
        }
        this.imagemURL = resultado.cover_image();
        this.generos = resultado.genre();
        this.gravadoras = resultado.label();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public List<String> getGravadoras() {
        return gravadoras;
    }

    @Override
    public String toString() {
        return this.getTitulo() +
                "\nAno de Lançamento: "
                + this.getAnoDeLancamento()
                + "\nGêneros: "
                + this.getGeneros()
                + "\nGravadora: "
                + this.getGravadoras()
                + "\nURL para imagem da capa: "
                + this.getImagemURL()
                + "/////////////////////////////////\n";
    }
}
