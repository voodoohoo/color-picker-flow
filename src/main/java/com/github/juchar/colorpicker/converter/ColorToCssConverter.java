package com.github.juchar.colorpicker.converter;

import static java.text.MessageFormat.format;

import com.vaadin.flow.function.SerializableFunction;
import java.awt.Color;
import java.util.Locale;

/**
 * Converts a {@link java.awt.Color} to a CSS color.
 */
public class ColorToCssConverter implements SerializableFunction<Color, String> {

  @Override
  public String apply(Color color) {
    if (color != null) {
      final int red = color.getRed();
      final int green = color.getGreen();
      final int blue = color.getBlue();
      final int alpha = color.getAlpha();

      if (alpha != 1) {
        return format("rgb({0}, {1}, {2})", red, green, blue);
      } else {
        return format("rgba({0}, {1}, {2}, {3})", red, green, blue,
            String.format(Locale.ENGLISH, "%.2f", alpha / 255.0d));
      }
    } else {
      return null;
    }
  }
}
