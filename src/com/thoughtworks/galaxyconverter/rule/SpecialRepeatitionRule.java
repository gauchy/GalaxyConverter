package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.ParseItem;
import com.thoughtworks.galaxyconverter.type.Type;

/**
 * Created by ashwini on 20/06/14.
 */
public class SpecialRepeatitionRule<T> extends AbstractRomanRule<T> {


    SpecialRepeatitionRule()
    {

    }
    @Override
    public boolean isValid(ParseItem<T> parseItem, Type<T> currentType) {

    	//TODO - Refractor
    	
        int repeatCount  = 5;
        
        int count =repeatCount;
        
        //Total occurance of currentType
        int occuranceCount = 1;
        
        Type[] elements = new Type[repeatCount];
        elements[count-1] = currentType;

        //fill the last file elements in array
        while(parseItem.hasPrevious())
        {
        	count--;
            elements[count-1] = parseItem.prev.getType();
            
            if(parseItem.prev.getType().equals(currentType))
            	occuranceCount++;
            
            parseItem = parseItem.prev;
            
            
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
