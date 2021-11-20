package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;
/**
 * 
 * @author Yanis Donnant donnant / al�atoire - Jouer comme le dernier coup de
 *         l'adversaire, mais jouer parfois un coup au hasard. 2/3 joue donnant
 *         donnant et 1/3 joue aleatoire
 * 
 */
public class StrategyDonnantDonnantAleatoire implements Strategy {

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if (ennemiesList.size() > 0) {
			if (Tool.random0_1() <= 1) {
				return ennemiesList.get(ennemiesList.size() - 1);
			} else {
				return Tool.generateRandomCoup();
			}
		} else {
			return Tool.generateRandomCoup();
		}
	}

}
