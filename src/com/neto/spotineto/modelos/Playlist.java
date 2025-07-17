package com.neto.spotineto.modelos;

import com.neto.spotineto.utilitarios.Acoes;

import java.util.ArrayList;

public class Playlist implements Acoes {
    private String nome;
    private int likes;
    public ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome){
        this.nome = nome;
        this.likes = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void getMusicas(){
        if(!musicas.isEmpty()){
            for(int i = 0; i < musicas.size(); i++){
                System.out.println(i+1 + " -> " + musicas.get(i).getTitulo());
            }
        } else{
            System.out.println(this.getNome() + " está vazia!");
        }

    }

    public Musica getMusicaPorIndice(int indice){
        return this.musicas.get(indice);
    }

    public void adicionaMusica(Musica musica){
        musicas.add(musica);
        System.out.println(musica.getTitulo() + " Adicionada a " + this.getNome() + "!");
    }

    public void selecionaMaisOuvida(){
        Musica musicaMaisOuvida = this.getMusicaPorIndice(0);
        for(Musica musica : this.musicas){
            if(musica.getStreams() > musicaMaisOuvida.getStreams()){
                musicaMaisOuvida = musica;
            }
        }
        System.out.println("Escuta isso aqui: " + musicaMaisOuvida.getTitulo() + " ;) A galera ta gostando");
    }

    @Override
    public void reproduz() {
        System.out.println("\nReproduzindo Agora: " + musicas.get(0).getTitulo());
        System.out.println("Próxima a tocar: " + musicas.get(1).getTitulo());
        musicas.get(0).streams += 1;
    }

    @Override
    public void curte() {
        this.likes += 1;
        System.out.println(this.getNome() + " agora tem " + this.likes + " curtidas!");
    }
}
