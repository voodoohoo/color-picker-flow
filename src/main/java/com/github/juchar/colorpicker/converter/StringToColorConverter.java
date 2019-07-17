package com.github.juchar.colorpicker.converter;

import com.vaadin.flow.function.SerializableFunction;
import java.awt.Color;
import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @see ColorToCssConverter
 */
public abstract class StringToColorConverter implements
    SerializableFunction<String, Optional<Color>> {

  @Override
  public Optional<Color> apply(String color) {
    return getPatterns().stream()
        .map(p -> p.matcher(color))
        .filter(Matcher::matches)
        .map(this::getColor).findFirst();
  }

  protected abstract Collection<Pattern> getPatterns();

  protected abstract Color getColor(Matcher matcher);
}
