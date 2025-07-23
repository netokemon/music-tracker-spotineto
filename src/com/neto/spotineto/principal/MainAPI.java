package com.neto.spotineto.principal;

import com.google.gson.Gson;
import com.neto.spotineto.modelos.ListaDeMusicasAPI;
import com.neto.spotineto.modelos.Musica;
import com.neto.spotineto.modelos.MusicaResponse;
import com.neto.spotineto.utilitarios.ConexaoAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da música que você deseja buscar: ");
        var nomeBusca = scanner.nextLine();

        try{
            ConexaoAPI conexao = new ConexaoAPI();
            String responseBody = conexao.buscaMusica(nomeBusca);
            Gson gson = new Gson();
            ListaDeMusicasAPI dgsResponse = gson.fromJson(responseBody, ListaDeMusicasAPI.class);
            List<MusicaResponse> resultados = dgsResponse.getResultados().stream()
                    .filter(m -> m.year() != null)
                    .toList();


            if(!resultados.isEmpty()) {
                List<Musica> musicas = new ArrayList<Musica>();
                for (MusicaResponse m : resultados) {
                    Musica musica = new Musica(m);
                    musicas.add(musica);
                }
                musicas.stream()
                        .sorted(Comparator.comparing(Musica::getAnoDeLancamento)
                                .reversed())
                                    .forEach(System.out::println);
            } else{
                System.out.println("Não foram encontrados resultados para sua busca! :(");
            }
        } catch(NumberFormatException e){
            System.err.println("Erro ao converter dados da API: " + e.getMessage());
        } catch(NullPointerException e){
            System.err.println("Nenhum resultado encontrado para sua busca. :( (" + e.getMessage() + ")" );
        }

    }
}
