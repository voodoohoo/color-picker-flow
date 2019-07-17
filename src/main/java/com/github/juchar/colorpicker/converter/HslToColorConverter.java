package com.github.juchar.colorpicker.converter;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @see ColorToCssConverter
 */
public class HslToColorConverter extends StringToColorConverter {

  private final static Collection<Pattern> PATTERNS = Arrays.asList(
      Pattern.compile(
          "hsl\\((?:(-?\\d+(?:\\.\\d+)*)\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)%\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)%\\s*)\\)"),
      Pattern.compile(
          "hsla\\((?:(-?\\d+(?:\\.\\d+)*)\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)%\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)%\\s*,\\s*)(?:(-?\\d+(?:\\.\\d+)*)\\s*)\\)"));

  private static Color hslToColor(float h, float s, float l, float alpha) {
    h = h % 360.0f;
    h /= 360f;
    s /= 100f;
    l /= 100f;

    float q = l < 0.5 ? l * (1 + s) : (l + s) - (s * l);
    float p = 2 * l - q;

    float r = Math.max(0, HueToRGB(p, q, h + (1.0f / 3.0f)));
    float g = Math.max(0, HueToRGB(p, q, h));
    float b = Math.max(0, HueToRGB(p, q, h - (1.0f / 3.0f)));

    r = Math.min(r, 1.0f);
    g = Math.min(g, 1.0f);
    b = Math.min(b, 1.0f);

    return new Color(r, g, b, alpha);
  }

  private static float HueToRGB(float p, float q, float h) {
    if (h < 0) {
      h += 1;
    }

    if (h > 1) {
      h -= 1;
    }

    if (6 * h < 1) {
      return p + ((q - p) * 6 * h);
    }

    if (2 * h < 1) {
      return q;
    }

    if (3 * h < 2) {
      return p + ((q - p) * 6 * ((2.0f / 3.0f) - h));
    }

    return p;
  }

  @Override
  protected Collection<Pattern> getPatterns() {
    return PATTERNS;
  }

  @Override
  protected Color getColor(Matcher matcher) {
    final float hue = Float.parseFloat(matcher.group(1));
    final float saturation = Float.parseFloat(matcher.group(2));
    final float lightness = Float.parseFloat(matcher.group(3));
    final float alpha = matcher.groupCount() < 4 ? 1 : Float.parseFloat(matcher.group(4));
    return hslToColor(hue, saturation, lightness, alpha);
  }
}
