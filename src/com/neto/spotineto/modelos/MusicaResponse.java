package com.neto.spotineto.modelos;

import java.util.List;

public record MusicaResponse(String title, String year, List<String> genre, String cover_image, List<String> label) {
}
