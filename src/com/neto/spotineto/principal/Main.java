package com.neto.spotineto.principal;

import com.neto.spotineto.modelos.Musica;
import com.neto.spotineto.modelos.Playlist;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Musica apt = new Musica("APT", "Rosé e Bruno Mars", 200, "Pop");
        apt.setAlbum("Rosie");
        Musica justKeepWatching = new Musica("Just Keep Watching", "Tate McRae", 170, "Pop");
        Musica desmitificar = new Musica("Desmitificar", "Marina Sena", 200, "Pop");
        desmitificar.setAlbum("Coisas Naturais");
        Musica sportsCar = new Musica("Sports Car", "Tate McRae", 160, "Pop");
        sportsCar.setAlbum("So Close To What?");
        Musica highFashion = new Musica("High Fashion", "Addison Rae", 180, "Pop");
        highFashion.setAlbum("Addison");

        Playlist playlist = new Playlist("Hits de Neto");
        playlist.adicionaMusica(justKeepWatching);
        playlist.adicionaMusica(desmitificar);
        playlist.adicionaMusica(sportsCar);
        playlist.adicionaMusica(highFashion);
        playlist.adicionaMusica(apt);

        playlist.getMusicas();

        //Método compareTo adicionado a classe Audio, por isso o collections.sort entende o sort
        Collections.sort(playlist.musicas);

        //
        playlist.musicas.sort(Comparator.comparing(Musica::getStreams));
        System.out.println(playlist.musicas);
    }
}