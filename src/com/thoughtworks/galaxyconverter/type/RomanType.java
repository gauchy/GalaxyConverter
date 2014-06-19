package com.thoughtworks.galaxyconverter.type;

/**
 * Created by ashwini on 19/06/14.
 */
public class RomanType<T> extends AbstractType<T> {

    int value ;
    RomanType(String name , Integer value , Integer order)
    {
        this.name = name;
        this.order = order;
        this.value = value;
    }

    @Override
    public T getValue()
    {
        return null;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof RomanType)
           return this.name.equals(((RomanType)obj).name);
        return false;
    }
}
