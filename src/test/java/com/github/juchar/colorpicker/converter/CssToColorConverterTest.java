package com.github.juchar.colorpicker.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import org.junit.Test;

public class CssToColorConverterTest {

  @Test
  public void testConvert() {
    CssToColorConverter converter = new CssToColorConverter();

    assertThat(converter.apply("#fff"), is(Color.WHITE));
    assertThat(converter.apply("#ffff"), is(Color.WHITE));
    assertThat(converter.apply("#ffffff"), is(Color.WHITE));
    assertThat(converter.apply("#ffffffff"), is(Color.WHITE));
    assertThat(converter.apply("#ffffff80").getAlpha(), is(128));
    assertThat(converter.apply("#ffffff00").getAlpha(), is(0));

    assertThat(converter.apply("hsl(0,100%,100%)"), is(Color.WHITE));
    assertThat(converter.apply("hsla(0,100%,100%,1)"), is(Color.WHITE));
    assertThat(converter.apply("hsla(0,100%,100%,0.5)").getAlpha(), is(128));
    assertThat(converter.apply("hsla(0,100%,100%,0)").getAlpha(), is(0));

    assertThat(converter.apply("rgb(255,255,255)"), is(Color.WHITE));
    assertThat(converter.apply("rgba(255,255,255,1)"), is(Color.WHITE));
    assertThat(converter.apply("rgba(255,255,255,0.5)").getAlpha(), is(128));
    assertThat(converter.apply("rgba(255,255,255,0)").getAlpha(), is(0));
  }
}
