package com.thoughtworks.galaxyconverter.type;

/**
 * Created by ashwini on 19/06/14.
 */
public interface Type<T>
{
    public String getName();
    public int getOrder();
    public T getValue();
}
