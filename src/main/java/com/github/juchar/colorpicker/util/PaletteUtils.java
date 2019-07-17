package com.github.juchar.colorpicker.util;

import elemental.json.Json;
import elemental.json.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class PaletteUtils {

  private PaletteUtils() {
    // Prevent instantiation
  }

  public static <T> JsonArray paletteToJson(Collection<T> palette,
      Function<T, String> toPresentation) {
    final List<String> convertedPalette
        = palette.stream().map(toPresentation).collect(Collectors.toList());
    final JsonArray jsonPalette = Json.createArray();

    for (int i = 0; i < palette.size(); i++) {
      jsonPalette.set(i, convertedPalette.get(i));
    }

    return jsonPalette;
  }

  public static <T> JsonArray palettesToJson(Collection<Collection<T>> palettes,
      Function<T, String> toPresentation) {
    final List<Collection<T>> convertedPalettes = new ArrayList<>(palettes);
    final JsonArray jsonPalettes = Json.createArray();

    for (int i = 0; i < convertedPalettes.size(); i++) {
      jsonPalettes.set(i, paletteToJson(convertedPalettes.get(i), toPresentation));
    }

    return jsonPalettes;
  }

  public static JsonArray palettesToJson(Collection<Collection<String>> palettes) {
    return palettesToJson(palettes, Function.identity());
  }

  public static <T> List<T> jsonToPalette(JsonArray jsonPalette, Function<String, T> toColor) {
    List<T> palette = new ArrayList<>(jsonPalette.length());

    for (int i = 0; i < jsonPalette.length(); i++) {
      palette.add(toColor.apply(jsonPalette.getString(i)));
    }

    return palette;
  }

  public static <T> List<List<T>> jsonToPalettes(JsonArray jsonPalettes,
      Function<String, T> toColor) {
    List<List<T>> palettes = new ArrayList<>(jsonPalettes.length());

    for (int i = 0; i < jsonPalettes.length(); i++) {
      palettes.add(jsonToPalette(jsonPalettes.getArray(i), toColor));
    }

    return palettes;
  }

  public static List<List<String>> jsonToPalettes(JsonArray jsonPalettes) {
    return jsonToPalettes(jsonPalettes, Function.identity());
  }
}
