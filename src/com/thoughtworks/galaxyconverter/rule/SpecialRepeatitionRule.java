package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 20/06/14.
 */
public class SpecialRepeatitionRule implements Rule {


    public SpecialRepeatitionRule()
    {

    }
    @Override
    public boolean isValid(Token token, Type currentType) {

    	//TODO - Refractor
    	
        int repeatCount  = 5;
        
        int count =repeatCount;
        
        //Total occurance of currentType
        int occuranceCount = 1;
        
        Type[] elements = new Type[repeatCount];
        elements[count-1] = currentType;

        //fill the last file elements in array
        while(token.hasPrevious())
        {
        	count--;
            elements[count-1] = token.prev.getType();
            
            if(token.prev.getType().equals(currentType))
            	occuranceCount++;
            
            token = token.prev;
            
            
            if(count ==0)
            	break;
        }
        
        //if occurance is not 4 return valid else check 4th element in the array is different
        if(occuranceCount != (repeatCount-1))
        	return true;
        else if(elements[repeatCount-2].equals(currentType))
        	return false;
        
        return true;
        
        
        
        
        
    }
}
