package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.ParseItem;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 19/06/14.
 */
public interface Rule<T> {

    boolean isValid(ParseItem<T> parseItem , Type<T> currentType);
}
