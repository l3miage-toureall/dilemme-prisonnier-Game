package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool.Coup;

/*
 * 
 * @author Allassane 
 * Rancunier doux coopérer jusqu'à ce que l'adversaire trahisse 
 * puis si trahison punir par 
 * t,t,t,t,c,c.
 * 
 */

public class StrategyRancunierDoux implements Strategy {
	int tourOfPunishment = 0;

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if(ennemiesList.size() >= 1) {
			if(tourOfPunishment == 0 && ennemiesList.get(ennemiesList.size()-1) == Coup.COOPERER) {
				return Coup.COOPERER;
			}
			else if (tourOfPunishment == 0 && ennemiesList.get(ennemiesList.size()-1) != Coup.COOPERER) {
				tourOfPunishment = 6;
				tourOfPunishment--;
				return Coup.TRAHIR;
			}
			else if (tourOfPunishment >2) {
				tourOfPunishment--;
				return Coup.TRAHIR;
			}
			else {
				if(tourOfPunishment < 3) {
					return Coup.COOPERER;
				}
			}
		}
		return Coup.COOPERER;
	}

}
