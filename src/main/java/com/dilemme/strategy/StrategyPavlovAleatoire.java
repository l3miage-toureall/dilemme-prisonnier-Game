package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

/*
 * @author Allassane 
 * Pavlov Aleatoire  Si 5 ou 3 points ont été obtenus au tour précédent, répéter le dernier choix, mais faire
 * parfois des choix aléatoires.
 *
 */

public class StrategyPavlovAleatoire implements Strategy{

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if(mineList.size()>=1 && ennemiesList.size() >=1) {
			if( (mineList.get(mineList.size()-1)== Coup.TRAHIR && ennemiesList.get(ennemiesList.size()-1)== Coup.COOPERER) || 
					(mineList.get(mineList.size()-1)== Coup.COOPERER && ennemiesList.get(ennemiesList.size()-1)== Coup.COOPERER) ) {
				if(Tool.random0_4()==3) {
					if(Tool.random0_1() == 1) {
						return Coup.COOPERER;
					}
					else {
						return Coup.TRAHIR;
					}
				}
				else {			
					return mineList.get(mineList.size()-1);
				}
			}
			else {
				return Tool.generateRandomCoup();
			}
		}
		else {
			return Tool.generateRandomCoup();

		}
	}


}
