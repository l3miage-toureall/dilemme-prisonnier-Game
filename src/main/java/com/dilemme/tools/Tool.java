package com.dilemme.tools;

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

}
