package com.neto.spotineto.utilitarios;

public class Conversor {

    public static String converteEmMinutos(int duracaoEmSegundos){
        int novoMinuto = duracaoEmSegundos / 60;
        int novoSegundo = duracaoEmSegundos % 60;
        return String.format("%02d:%02d", novoMinuto, novoSegundo);
    }
}
