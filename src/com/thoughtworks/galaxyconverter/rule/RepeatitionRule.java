package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.ParseItem;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 20/06/14.
 */
public class RepeatitionRule<T> extends AbstractRomanRule<T> {

    int repeatCount;
    RepeatitionRule(int repeatCount)
    {
        this.repeatCount = repeatCount;
    }

    @Override
    public boolean isValid(ParseItem<T> parseItem, Type<T> currentType)
    {
        int count =1;
        if(parseItem.hasPrevious())
        {

             if(currentType.equals(parseItem.prev))
                 count++;
             
             parseItem = parseItem.prev;

        }
        //if count is less or equal to allowed repeat count then return valid
        return count <= repeatCount;
    }


}
