package com.github.juchar.colorpicker;

import com.github.juchar.colorpicker.converter.ColorToCssConverter;
import com.github.juchar.colorpicker.converter.CssToColorConverter;
import com.vaadin.flow.function.SerializableFunction;
import java.awt.Color;

public interface ColorPickerBaseColor extends ColorPickerBase<Color> {

  SerializableFunction<String, Color> PRESENTATION_TO_MODEL = new CssToColorConverter();
  SerializableFunction<Color, String> MODEL_TO_PRESENTATION = new ColorToCssConverter();

  @Override
  default SerializableFunction<String, Color> getPresentationToModel() {
    return PRESENTATION_TO_MODEL;
  }

  @Override
  default SerializableFunction<Color, String> getModelToPresentation() {
    return MODEL_TO_PRESENTATION;
  }
}
