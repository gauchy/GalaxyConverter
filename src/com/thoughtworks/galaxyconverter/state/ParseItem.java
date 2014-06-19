package com.thoughtworks.galaxyconverter.state;

import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 19/06/14.
 */
public abstract class ParseItem<T> {

    public ParseItem<T> next;
    public ParseItem<T> prev;
    private Parser parser;
    private Type<T> type;

    public Type<T> getType() {
        return type;
    }

    public void setType(Type<T> type) {
        this.type = type;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public boolean hasNext()
    {
        return false;
        //TODO
    }

    public boolean hasPrevious()
    {
        return false;
        //TODO
    }



}
