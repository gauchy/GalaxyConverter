package com.thoughtworks.galaxyconverter.parser;

import java.util.List;

import com.thoughtworks.galaxyconverter.rule.Rule;
import com.thoughtworks.galaxyconverter.rule.RuleException;
import com.thoughtworks.galaxyconverter.grammar.Type;
import com.thoughtworks.galaxyconverter.state.Token;

public class TypeParser implements Parser {

    List<Rule> rules;
	
	public TypeParser(Type type, List<Rule> rules)
	{
	    this.rules = rules;
	}
	
	@Override
	public boolean validate(Token token) throws RuleException
	{
        for(Rule rule : rules)
        {
            rule.isValid(token);
        }
        return true;
	}

	

}
