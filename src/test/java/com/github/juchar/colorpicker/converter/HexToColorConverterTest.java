package com.github.juchar.colorpicker.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import java.util.Optional;
import org.junit.Test;

public class HexToColorConverterTest {

  @Test
  public void testConvert() {
    HexToColorConverter converter = new HexToColorConverter();

    assertThat(converter.apply("#fff"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("#ffff"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("#ffffff"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("#ffffffff"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("#ffffff80").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("#ffffff00").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("#000"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("#000f"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("#000000"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("#000000ff"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("#00000080").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("#00000000").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("#f0f"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("#f0ff"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("#ff00ff"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("#ff00ffff"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("#ff00ff80").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("#ff00ff00").map(Color::getAlpha), is(Optional.of(0)));
  }
}
