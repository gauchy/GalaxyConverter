package com.thoughtworks.galaxyconverter.state;

/**
 * Created by ashwini on 19/06/14.
 */
public interface ParseItemBuilder<T> {

      public ParseItem<T> buildParseItem(String arg);
}
