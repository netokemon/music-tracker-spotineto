package com.neto.spotineto.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscogsResponse {
    @SerializedName("results")
    private List<Musica> resultados;

    public List<Musica> getResultados() {
        return resultados;
    }
}
