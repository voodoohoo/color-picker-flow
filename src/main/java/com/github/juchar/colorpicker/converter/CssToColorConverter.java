package com.github.juchar.colorpicker.converter;

import com.vaadin.flow.function.SerializableFunction;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Converts a CSS color to a {@link java.awt.Color}.
 */
public class CssToColorConverter implements SerializableFunction<String, Color> {

  private final Collection<StringToColorConverter> converters;

  public CssToColorConverter() {
    converters = new ArrayList<>();
    converters.add(new HexToColorConverter());
    converters.add(new RgbToColorConverter());
    converters.add(new HslToColorConverter());
  }

  @Override
  public Color apply(String color) {
    return converters.stream()
        .map(c -> c.apply(color))
        .filter(Optional::isPresent)
        .findFirst()
        .map(Optional::get).orElse(null);
  }
}
