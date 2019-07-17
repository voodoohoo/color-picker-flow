package com.github.juchar.colorpicker.converter;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @see ColorToCssConverter
 */
public class RgbToColorConverter extends StringToColorConverter {

  private final static Collection<Pattern> PATTERNS = Arrays.asList(
      Pattern.compile("rgb\\((?:(-?\\d+)\\s*,\\s*)(?:(-?\\d+)\\s*,\\s*)(?:(-?\\d+)\\s*)\\)"),
      Pattern.compile("rgb\\((?:(-?\\d+)%\\s*,\\s*)(?:(-?\\d+)%\\s*,\\s*)(?:(-?\\d+)%\\s*)\\)"),
      Pattern.compile(
          "rgba\\((?:(-?\\d+)\\s*,\\s*)(?:(-?\\d+)\\s*,\\s*)(?:(-?\\d+)\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)\\s*)\\)"),
      Pattern.compile(
          "rgba\\((?:(-?\\d+)%\\s*,\\s*)(?:(-?\\d+)%\\s*,\\s*)(?:(-?\\d+)%\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)\\s*)\\)"));

  @Override
  protected Collection<Pattern> getPatterns() {
    return PATTERNS;
  }

  @Override
  protected Color getColor(Matcher matcher) {
    final int red = Integer.parseInt(matcher.group(1));
    final int green = Integer.parseInt(matcher.group(2));
    final int blue = Integer.parseInt(matcher.group(3));
    final int alpha = matcher.groupCount() < 4
        ? 255
        : (int) Math.round((Double.parseDouble(matcher.group(4)) * 255.0d));
    return new Color(red, green, blue, alpha);
  }
}
