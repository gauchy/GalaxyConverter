package com.thoughtworks.galaxyconverter.client;

import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.state.RomanTokenBuilder;
import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.state.TokenBuilder;

public class EvaluatorClient {
	
	public static void main(String args[]) throws Exception
	{
		InitialiseHelper.intialise();

        String [] toks = new String[]{"C","C","C"};
        TokenBuilder tokenBuilder = new RomanTokenBuilder(toks);
        Token start = tokenBuilder.buildTokens();

        Token current = start;
        while(true)
        {
            System.out.println(current.getType().getName());
            Parser parser = current.getParser();

            

            if(!current.hasNext())
                break;

            current = current.next;
        }
        System.out.println("Done");
	}

}
