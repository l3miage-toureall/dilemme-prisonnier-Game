package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;
/*
 * @author Allassane 
 * Pacificateur naîf jouer comme le dernier coup de l'adversaire coopérer sur certain coup alors que 
 * l'adversaire a trahit
 *  
 */
public class StrategyPacificateurNaif implements Strategy {

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		
		if(ennemiesList.size() >= 1) {
			if(Tool.random0_4() == 3 && ennemiesList.get(ennemiesList.size()-1) == Coup.TRAHIR) {
				return Coup.COOPERER;
			}
			else {
				return ennemiesList.get(ennemiesList.size()-1);
			}	
		}
		else {
			if(Tool.random0_1() == 1) {
				return Coup.COOPERER;
			}
			else {
				return Coup.TRAHIR;
			}
		}
	}

}
