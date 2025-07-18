package com.neto.spotineto.utilitarios;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CodificadorURL {
    public static String codificaNome(String n){
        return URLEncoder.encode(n, StandardCharsets.UTF_8);
    }
}
