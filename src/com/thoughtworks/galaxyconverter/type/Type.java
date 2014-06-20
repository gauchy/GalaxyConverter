package com.thoughtworks.galaxyconverter.type;

/**
 * Created by ashwini on 19/06/14.
 */
public class Type
{
    int value ;
    protected String name;
    protected int order;

    public String getName()
    {
        return name;
    }

    public int getOrder()
    {
        return order;
    }
    public Type(String name , Integer order)
    {
        this.name = name;
        this.order = order;
    }

    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
    	
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Type)
           return this.name.equals(((Type)obj).name);
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
