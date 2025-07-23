package com.neto.spotineto.modelos;
import com.google.gson.annotations.SerializedName;
import com.neto.spotineto.utilitarios.Acoes;
import com.neto.spotineto.utilitarios.Conversor;

public class Audio implements Acoes, Comparable<Audio> {
    private String titulo;
    private String imagemURL;
    private int duracaoEmSegundos;
    protected int streams;
    protected int likes;
    private int anoDeLancamento;

    public Audio(String titulo, String anoDeLancamento, String imagemURL){
        this.titulo = titulo;
        try{
            this.anoDeLancamento = Integer.valueOf(anoDeLancamento);
        } catch(NumberFormatException e){
            this.anoDeLancamento = 0;
        }
        this.imagemURL = imagemURL;
        this.likes = 0;
        this.streams = 0;
    }

    public String getTitulo() {
        return titulo;
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
        System.out.println("\nReproduzindo Agora: " + this.titulo);
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
