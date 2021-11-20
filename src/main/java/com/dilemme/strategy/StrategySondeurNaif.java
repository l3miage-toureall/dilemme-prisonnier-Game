package com.dilemme.strategy;

import java.util.List;
/*
**
* 
* @author Allassane jouer comme le dernier coupde l'adversiare et parfois (20% du temps) trahir
* 
*
* 
*/

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

public class StrategySondeurNaif implements Strategy {

	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if(ennemiesList.size() >= 1) {
			if(Tool.random0_1() == 3) {
				return Coup.TRAHIR;
			}
			else {
				return ennemiesList.get(ennemiesList.size()-1);
			}	
		}
		else {
			return Coup.TRAHIR;
		}
	}

}

