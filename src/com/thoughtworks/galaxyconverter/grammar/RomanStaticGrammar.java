package com.thoughtworks.galaxyconverter.grammar;

import java.util.*;

import com.thoughtworks.galaxyconverter.evaluate.DefaultEvaluator;
import com.thoughtworks.galaxyconverter.evaluate.Evaluator;
import com.thoughtworks.galaxyconverter.evaluate.SubstractEvaluator;
import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.parser.TypeParser;
import com.thoughtworks.galaxyconverter.rule.*;
import com.thoughtworks.galaxyconverter.state.RomanTokenConstant;

public class RomanStaticGrammar implements Grammar {

	private Map<Type , Parser> typeVsParser = new HashMap<Type , Parser>();
    private List<Type> types = new ArrayList<Type>();
    boolean built = false;


	public void buildValidator() {

        if(built)
            return;


        Rule repeat1 = new RepeatitionRule(1);
        Rule  repeat3 = new RepeatitionRule(3);
		Rule beforeRule = new BeforeRule();
        Rule repeatSpecial = new SpecialRepeatitionRule();

		Type typeI = createType(RomanTokenConstant.I, RomanTokenConstant.I_value, 1);
        Type typeV = createType(RomanTokenConstant.V, RomanTokenConstant.V_value, 2);
        Type typeX = createType(RomanTokenConstant.X, RomanTokenConstant.X_value, 3);
        Type typeL = createType(RomanTokenConstant.L, RomanTokenConstant.L_value, 4);
        Type typeC = createType(RomanTokenConstant.C, RomanTokenConstant.C_value, 5);
        Type typeD = createType(RomanTokenConstant.D, RomanTokenConstant.D_value, 6);
        Type typeM = createType(RomanTokenConstant.M, RomanTokenConstant.M_value, 7);

        types.add(typeI);
        types.add(typeV);
        types.add(typeX);
        types.add(typeL);
        types.add(typeC);
        types.add(typeD);
        types.add(typeM);

		Parser parseI = createParser(new Rule[]{repeat3}, typeI);
        Parser parseV = createParser(new Rule[]{repeat1,beforeRule , new SpecialBeforeRule(typeI)} , typeV);
        Parser parseX = createParser(new Rule[]{repeat3,repeatSpecial,beforeRule,new SpecialBeforeRule(typeI)},typeX);
        Parser parseL = createParser(new Rule[]{repeat1,beforeRule , new SpecialBeforeRule(typeX)} , typeL);
        Parser parseC = createParser(new Rule[]{repeat3,repeatSpecial,beforeRule,new SpecialBeforeRule(typeX)},typeC);
        Parser parseD = createParser(new Rule[]{repeat1,beforeRule , new SpecialBeforeRule(typeC)} , typeD);
        Parser parseM = createParser(new Rule[]{repeat3,repeatSpecial,beforeRule,new SpecialBeforeRule(typeC)},typeM);

        typeVsParser.put(typeI,parseI);
        typeVsParser.put(typeV,parseV);
        typeVsParser.put(typeX,parseX);
        typeVsParser.put(typeL,parseL);
        typeVsParser.put(typeC,parseC);
        typeVsParser.put(typeD,parseD);
        typeVsParser.put(typeM,parseM);

        built = true;
	}

	private Parser createParser(Rule[] rules,Type type)
	{
		return new TypeParser(type , Arrays.asList(rules));

	}



    @Override
    public void buildGrammar() {
        buildValidator();
        buildEvaluator();
    }

    private void buildEvaluator() {

    }

    @Override
	public Parser getParser(Type type) {
        return typeVsParser.get(type);
	}

    @Override
    public Parser getParser(String name) {
        for(Map.Entry<Type,Parser> entry: typeVsParser.entrySet())
        {
            if(entry.getKey().getName().equals(name))
                return  entry.getValue();
        }
        return null;
    }

    @Override
    public Evaluator[] getEvaluators(String name) {
        return new Evaluator[]{new DefaultEvaluator(),new SubstractEvaluator()};
    }

    @Override
    public Evaluator[] getEvaluators(Type type) {
        return new Evaluator[]{new DefaultEvaluator(),new SubstractEvaluator()};
    }

    @Override
    public Type getType(String name) throws GrammarException {

        for(Type type : types)
        {
            if(type.getName().equals(name))
                return type;
        }
        throw new GrammarException("Invalid type");
    }

    private Type createType(String string, int value, int order) {
        Type type = new Type(string,order);
        type.setValue(value);

        return type;
    }


}
