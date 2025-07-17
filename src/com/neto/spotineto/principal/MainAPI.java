package com.neto.spotineto.principal;

import com.google.gson.Gson;
import com.neto.spotineto.modelos.ListaDeMusicasAPI;
import com.neto.spotineto.modelos.Musica;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainAPI {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Insira sua Token do discogs aqui! -->
        String tokenAPI = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da música que você deseja buscar: ");
        var nomeBusca = scanner.nextLine();

        String nomeCodificado = URLEncoder.encode(nomeBusca, StandardCharsets.UTF_8);
        String endereco = "https://api.discogs.com/database/search?title=" + nomeCodificado + "&token=" + tokenAPI + "&page=1&type=release";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        Gson gson = new Gson();
        ListaDeMusicasAPI dgsResponse = gson.fromJson(responseBody, ListaDeMusicasAPI.class);
        Musica musica = new Musica(dgsResponse.getResultados().getFirst());
        System.out.println(musica);
    }
}
