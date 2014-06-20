package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 20/06/14.
 */
public class RepeatitionRule implements Rule {

    int repeatCount;
    public RepeatitionRule(int repeatCount)
    {
        this.repeatCount = repeatCount;
    }

    @Override
    public boolean isValid(Token token, Type currentType)
    {
        int count =1;
        if(token.hasPrevious())
        {

             if(currentType.equals(token.prev))
                 count++;
             
             token = token.prev;

        }
        //if count is less or equal to allowed repeat count then return valid
        return count <= repeatCount;
    }


}
