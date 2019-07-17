package com.github.juchar.colorpicker.converter;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @see ColorToCssConverter
 */
public class HexToColorConverter extends StringToColorConverter {

  // ATTENTION: For usage with capturing groups quantifiers do not work
  private final static List<Pattern> PATTERNS = Arrays.asList(
      Pattern.compile("#((?:(?:[0-9a-fA-F][0-9a-fA-F])" +
          "|(?:[0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F])" +
          "|(?:[0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F])" +
          "|(?:[0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F])))"),
      Pattern.compile("#([0-9a-fA-F][0-9a-fA-F][0-9a-fA-F])"));

  @Override
  protected Collection<Pattern> getPatterns() {
    return PATTERNS;
  }

  @Override
  protected Color getColor(Matcher matcher) {
    String hex = matcher.group(1);
    if (hex.length() == 3 || hex.length() == 4) {
      hex = hex.replaceAll(".", "$0$0");
    }

    int red = Integer.valueOf(hex.substring(0, 2), 16);
    int green = Integer.valueOf(hex.substring(2, 4), 16);
    int blue = Integer.valueOf(hex.substring(4, 6), 16);
    int alpha = hex.length() == 8 ? Integer.valueOf(hex.substring(6, 8), 16) : 255;

    return new Color(red, green, blue, alpha);
  }
}
