package com.neto.spotineto.modelos;
import com.google.gson.annotations.SerializedName;
import com.neto.spotineto.utilitarios.Acoes;
import com.neto.spotineto.utilitarios.Conversor;

public class Audio implements Acoes, Comparable<Audio> {
    @SerializedName("title")
    private String titulo;
    private String artista;
    @SerializedName("cover_image")
    private String imagemURL;
    private int duracaoEmSegundos;
    protected int streams;
    protected int likes;
    @SerializedName("year")
    private int anoDeLancamento;

    public Audio(String titulo, String artista, int duracaoEmSegundos){
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoEmSegundos = duracaoEmSegundos;
        this.likes = 0;
        this.streams = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public int getStreams() {
        return streams;
    }

    public int getLikes() {
        return likes;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }



    @Override
    public void reproduz(){
        System.out.println("\nReproduzindo Agora: " + this.titulo + ", de " + this.artista);
        System.out.println("<<<<<<<<<<<<< " + Conversor.converteEmMinutos(this.duracaoEmSegundos) + " " + this.getLikes() + " Curtidas >>>>>>>>>>>>>");
        this.streams += 1;
    }

    @Override
    public void curte(){
        this.likes += 1;
        System.out.println("<<<<< Curtidas: " + this.getLikes() + " >>>>>");
    }


    @Override
    public int compareTo(Audio outroAudio) {
        return this.getTitulo().compareTo(outroAudio.getTitulo());
    }

}
