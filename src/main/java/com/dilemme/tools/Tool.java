package com.dilemme.tools;

import java.util.List;

import com.dilemme.data.object.Party;
import com.dilemme.data.object.Playeur;

public class Tool {
	
	public static enum Coup {
		COOPERER,
		TRAHIR
	}
	
	public static enum StrategyAutomatic{
		STRATEGY_COOPERATE,
		STRATEGY_BETRAY,
	}
	
	public static int randomId() {
		int number = 1+ (int)(Math.random() * (500 - 1));
		return number;
	}
	public static int random0_1() {
		int number = 0 + (int)(Math.random() * (1 - 0));
		return number;
	}
	public static Coup generateRandomCoup() {
		return random0_1()== 1? Coup.COOPERER:Coup.COOPERER;
		
	}
	public static int random0_4() {
		int number = 1+ (int)(Math.random() * (4 - 1));
		return number;
	}
	public static Playeur getPlayeur(List<Playeur> playeurs, String name) {
		Playeur playeur = new Playeur("");
		for(Playeur p : playeurs) {
			if ( p.getName()== name) {
				playeur = p;
				
			}
		}
		return playeur;
		
	}
	public static Party getParty(List<Party> partys, int idParty) {
		Party party = new Party(null,-1);
		for(Party p : partys) {
			if(p.getId() == idParty) {
				party = p;
			}
		}
		return party;
	}

}
