package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

/**
 * 
 * @author Yanis Donnant donnant - Jouer comme le dernier coup de l'adversaire
 *
 */
public class StrategyDonnantDonnant implements Strategy {

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if (ennemiesList.size() > 0) {
			return ennemiesList.get(ennemiesList.size() - 1);
		} else {
			return Tool.generateRandomCoup();
		}
	}

}
