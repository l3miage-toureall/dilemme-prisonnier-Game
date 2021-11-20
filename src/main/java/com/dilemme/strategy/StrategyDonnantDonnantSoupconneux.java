package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

/*
 * @author Allassane 
 * Donnant donnant soupçonneux commencer par trahir puis jouer comme dans la stratégy donnant donnant*/

public class StrategyDonnantDonnantSoupconneux implements Strategy {
	
	 private int tour = 0;
	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if(isFirstDecisionStrategy(tour)) {
			tour++;
			return Coup.TRAHIR;
		}
		else {
			if (ennemiesList.size() > 0) {
				tour++;
				return ennemiesList.get(ennemiesList.size() - 1);
			} else {
				tour++;
				return Tool.generateRandomCoup();
			}
		}
	}

	private boolean isFirstDecisionStrategy(int tourWithStrategy) {
		return tourWithStrategy == 0;
	} 

}
