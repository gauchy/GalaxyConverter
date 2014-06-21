package com.thoughtworks.galaxyconverter.evaluate;

import com.thoughtworks.galaxyconverter.state.TokenContext;

public interface Evaluator {
	
	TokenContext evaluate(TokenContext tokenContext);

}
