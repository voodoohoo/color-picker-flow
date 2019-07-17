package com.github.juchar.colorpicker.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import java.util.Optional;
import org.junit.Test;

public class RgbToColorConverterTest {

  @Test
  public void testConvert() {
    RgbToColorConverter converter = new RgbToColorConverter();

    assertThat(converter.apply("rgb(255,255,255)"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("rgba(255,255,255,1)"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("rgba(255,255,255,0.5)").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("rgba(255,255,255,0)").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("rgb(0,0,0)"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("rgba(0,0,0,1)"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("rgba(0,0,0,0.5)").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("rgba(0,0,0,0)").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("rgb(255,0,255)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgba(255,0,255,1)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgba(255,0,255,0.5)").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("rgba(255,0,255,0)").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("rgb(255 ,0,255)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgb(255, 0,255)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgb(255,0 ,255)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgb(255,0, 255)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgb(255,0,255 )"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgb(255,0, 255)"), is(Optional.of(Color.MAGENTA)));

    assertThat(converter.apply("rgba(255, 0,255,1)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgba(255, 0, 255,1)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("rgba(255, 0, 255, 1)"), is(Optional.of(Color.MAGENTA)));
  }
}
