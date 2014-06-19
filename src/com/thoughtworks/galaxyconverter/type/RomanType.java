package com.thoughtworks.galaxyconverter.type;

/**
 * Created by ashwini on 19/06/14.
 */
public class RomanType extends AbstractType<Integer> {

    int value ;
    RomanType(String name , Integer value , Integer order)
    {
        this.name = name;
        this.order = order;
        this.value = value;
    }

    @Override
    public Integer getValue()
    {
        return null;
    }
}
