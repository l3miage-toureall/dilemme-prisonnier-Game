package com.dilemme.strategy;


import java.util.List;

import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

/**
 * @author Allassane 
 * Sondeur repentant jouer le dernier coup de l'adversaire et parfois coopérer
 * */

public class StrategySondeurRepentant  implements Strategy{
   
	@Override
	public Coup play(List<Coup> mineList, List<Coup> ennemiesList) {
		if(ennemiesList.size() >= 1) {
			if(Tool.random0_4() == 3) {
				return Coup.COOPERER;
			}
			else {
				return ennemiesList.get(ennemiesList.size()-1);
			}	
		}
		else {
			return Coup.COOPERER;
		}
	
	}

}
