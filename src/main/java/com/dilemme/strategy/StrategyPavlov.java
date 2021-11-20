package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

/*
 * @author Allassane
 * Palov répéter le dernier choix si 5 ou 3 point ont été obtenu au dernier tour
 * 
 */

public class StrategyPavlov implements Strategy {

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if(mineList.size()>=1 && ennemiesList.size() >= 1) {
			if( (mineList.get(mineList.size()-1)== Coup.TRAHIR && ennemiesList.get(ennemiesList.size()-1)== Coup.COOPERER) || 
				(mineList.get(mineList.size()-1)== Coup.COOPERER && ennemiesList.get(ennemiesList.size()-1)== Coup.COOPERER) ) {
				return mineList.get(mineList.size()-1);
				}
			else {
				if(Tool.random0_1() == 1) {
					return Coup.COOPERER;
				}
				else {
					return Coup.TRAHIR;
				}
			}
		}else {
			if(Tool.random0_1() == 1) {
				return Coup.COOPERER;
			}
			else {
				return Coup.TRAHIR;
			}
		}
	}

}
