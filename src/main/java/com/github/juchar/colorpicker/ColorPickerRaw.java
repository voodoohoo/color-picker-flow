package com.github.juchar.colorpicker;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("color-picker")
@HtmlImport("bower_components/color-picker/color-picker.html")
public class ColorPickerRaw extends AbstractSinglePropertyField<ColorPickerRaw, String>
    implements ColorPickerBaseRaw, HasStyle, Focusable<ColorPickerRaw>, HasTheme, HasSize {

  /**
   * Constructs an empty {@code ColorPicker}.
   */
  public ColorPickerRaw() {
    this(null, null);
  }

  /**
   * Constructs a {@code ColorPicker} with an initial value.
   *
   * @param initialValue the initial value
   */
  public ColorPickerRaw(String initialValue) {
    this(initialValue, null);
  }

  /**
   * Constructs a {@code ColorPicker} with an initial value and a previous value.
   *
   * @param initialValue the initial value
   * @param previousValue the previous value
   */
  public ColorPickerRaw(String initialValue, String previousValue) {
    super("value", null, true);
    setValue(initialValue);
    setPreviousValue(previousValue);
  }
}
