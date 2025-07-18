package com.neto.spotineto.utilitarios;

import com.neto.spotineto.excecoes.APISemTokenException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoAPI {
    //Insira sua Token do discogs aqui! -->
    private String tokenAPI = "";

    public HttpResponse<String> buscaMusica(String nomeBusca){
        String nomeCodificado = CodificadorURL.codificaNome(nomeBusca);
        String endereco = "https://api.discogs.com/database/search?title="
                + nomeCodificado + "&token=" + tokenAPI + "&page=1&type=release";
        try {
            if(tokenAPI.isEmpty()){
                throw new APISemTokenException("Não é possível conectar pois a chave API está vazia.");
            }
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch(IOException e){
            System.err.println("Houve um erro de rede: " + e.getMessage());
            return null;
        } catch (InterruptedException e){
            System.err.println("A ação foi interrompida: " + e.getMessage());
            return null;
        }
    }
}
