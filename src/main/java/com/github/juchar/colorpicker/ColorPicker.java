package com.github.juchar.colorpicker;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import java.awt.Color;

@Tag("color-picker")
@HtmlImport("bower_components/color-picker/color-picker.html")
public class ColorPicker extends AbstractSinglePropertyField<ColorPicker, Color>
    implements ColorPickerBaseColor, HasStyle, Focusable<ColorPicker>, HasTheme, HasSize {

  /**
   * Constructs an empty {@code ColorPicker}.
   */
  public ColorPicker() {
    this(null, null);
  }

  /**
   * Constructs a {@code ColorPicker} with an initial value.
   *
   * @param initialValue the initial value
   */
  public ColorPicker(Color initialValue) {
    this(initialValue, null);
  }

  /**
   * Constructs a {@code ColorPicker} with an initial value and a previous value.
   *
   * @param initialValue the initial value
   * @param previousValue the previous value
   */
  public ColorPicker(Color initialValue, Color previousValue) {
    super("value", null, String.class,
        ColorPickerBaseColor.PRESENTATION_TO_MODEL, ColorPickerBaseColor.MODEL_TO_PRESENTATION);
    setValue(initialValue);
    setPreviousValue(previousValue);
  }
}
