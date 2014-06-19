package com.thoughtworks.galaxyconverter.type;

/**
 * Created by ashwini on 19/06/14.
 */
public abstract class AbstractType<T> implements Type<T>
{

    protected String name;
    protected int order;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getOrder()
    {
        return order;
    }
}
