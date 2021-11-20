package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

public class StrategyAleatoire implements Strategy {
	
	@Override
	public Coup play(List<Coup> playeur1ListOfCoups, List<Coup> playeur2ListofCoups) {
		return Tool.generateRandomCoup();
	}

}