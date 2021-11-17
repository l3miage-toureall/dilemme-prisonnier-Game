package com.dilemme.data.object;

import java.util.ArrayList;
import java.util.List;

import com.dilemme.strategy.Strategy;
import com.dilemme.strategy.StrategyFactory;
import com.dilemme.tools.Tool.Coup;
import com.dilemme.tools.Tool.StrategyAutomatic;

public class Party {
	
	private Playeur playeur1;
	private Playeur playeur2 = null;
	private boolean isJoined = false;
	List<Coup> playeur1Coups = new ArrayList<Coup>(); 
	List<Coup> playeur2Coups = new ArrayList<Coup>();
	
	public Party(Playeur playeur, int numberOfTurn) {
		this.playeur1 = playeur;
	}
	
	void join(Playeur playeur) {
		playeur2 = playeur;
	}
	
	public Strategy leaveParty(Playeur playeur, StrategyAutomatic strategy) {
		if(playeur.getName() == this.playeur1.getName()) {
			this.playeur1 = null;
		    return chooseStrategy(strategy);
		}
		else {
			this.playeur2 = null;
			return chooseStrategy(strategy);
		}
	}

	private Strategy chooseStrategy(StrategyAutomatic strategy) {
		return StrategyFactory.getInstance(strategy);
		
	}

}
