package com.thoughtworks.galaxyconverter.grammar;

import com.thoughtworks.galaxyconverter.evaluate.Evaluator;
import com.thoughtworks.galaxyconverter.parser.Parser;

public class RomanXMLGrammar implements Grammar {

	private String xmlFileName = null; 
	private RomanXMLGrammar instance;
	public RomanXMLGrammar getInstance(String xmlFileName)
	{
		synchronized (instance) {
			if(instance == null)
			{
				instance = new RomanXMLGrammar(xmlFileName);
			}
			return instance;
			
		}
	}
	public RomanXMLGrammar getInstance() throws Exception
	{
		if(instance == null)
			throw new Exception("XML grammar not initialised");
		return instance;
		
	}
	
	RomanXMLGrammar(String xmlFileName)
	{
		
		this.xmlFileName = xmlFileName;
	}
	@Override
	public void buildGrammar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parser getParser(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Parser getParser(String name) {
        return null;
    }

    @Override
    public Evaluator[] getEvaluators(String name) {
        return new Evaluator[0];
    }

    @Override
    public Evaluator[] getEvaluators(Type type) {
        return new Evaluator[0];
    }

    @Override
    public Type getType(String name) {
        return null;
    }

}
