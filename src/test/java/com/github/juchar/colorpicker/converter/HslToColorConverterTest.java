package com.github.juchar.colorpicker.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import java.util.Optional;
import org.junit.Test;

public class HslToColorConverterTest {

  @Test
  public void testConvert() {
    HslToColorConverter converter = new HslToColorConverter();

    assertThat(converter.apply("hsl(0,100%,100%)"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("hsla(0,100%,100%,1)"), is(Optional.of(Color.WHITE)));
    assertThat(converter.apply("hsla(0,100%,100%,0.5)").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("hsla(0,100%,100%,0)").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("hsl(0,0%,0%)"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("hsla(0,0%,0%,1)"), is(Optional.of(Color.BLACK)));
    assertThat(converter.apply("hsla(0,0%,0%,0.5)").map(Color::getAlpha), is(Optional.of(128)));
    assertThat(converter.apply("hsla(0,0%,0%,0)").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("hsl(300,100%,50%)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsla(300,100%,50%,1)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsla(300,100%,50%,0.5)").map(Color::getAlpha),
        is(Optional.of(128)));
    assertThat(converter.apply("hsla(300,100%,50%,0)").map(Color::getAlpha), is(Optional.of(0)));

    assertThat(converter.apply("hsl(300 ,100%,50%)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsl(300, 100%,50%)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsl(300,100% ,50%)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsl(300,100%, 50%)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsl(300,100%,50% )"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsl(300,100%, 50%)"), is(Optional.of(Color.MAGENTA)));

    assertThat(converter.apply("hsla(300, 100%,50%,1)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsla(300, 100%, 50%,1)"), is(Optional.of(Color.MAGENTA)));
    assertThat(converter.apply("hsla(300, 100%, 50%, 1)"), is(Optional.of(Color.MAGENTA)));
  }
}
