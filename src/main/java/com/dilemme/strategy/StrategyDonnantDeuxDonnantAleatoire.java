package com.dilemme.strategy;
import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;


/**
 * 
 * @author Yanis Donnant pour deux donnants et al�atoire - Comme donnant donnant
 *         sauf que l'adversaire doit faire le m�me choix deux fois de suite
 *         avant la r�ciprocit�. Joue parfois un coup au hasard.
 *
 */
public class StrategyDonnantDeuxDonnantAleatoire implements Strategy {

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if (ennemiesList.size() >= 2) {
			if ((Tool.random0_1() <= 1)
					&& (ennemiesList.get(ennemiesList.size() - 1) == ennemiesList.get(ennemiesList.size() - 2))) {
				return ennemiesList.get(ennemiesList.size() - 1);
			} else {
				return Tool.generateRandomCoup();
			}
		} else {
			return Tool.generateRandomCoup();
		}
	}

}
