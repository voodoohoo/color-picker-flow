package com.github.juchar.colorpicker;

import com.vaadin.flow.function.SerializableFunction;

public interface ColorPickerBaseRaw extends ColorPickerBase<String> {

  @Override
  default SerializableFunction<String, String> getPresentationToModel() {
    return SerializableFunction.identity();
  }

  @Override
  default SerializableFunction<String, String> getModelToPresentation() {
    return SerializableFunction.identity();
  }
}
