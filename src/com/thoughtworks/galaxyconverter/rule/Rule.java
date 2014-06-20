package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 19/06/14.
 */
public interface Rule {

    boolean isValid(Token token, Type currentType);
}
