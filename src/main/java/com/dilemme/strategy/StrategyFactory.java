package com.dilemme.strategy;

public class StrategyFactory {

	public static Strategy getInstance(int idStrategy) {
	
		 switch(idStrategy) {
	        case 0:
	            return new StrategyCooperer();
	           
	        case 1:
	            return new StrategyTrahir();
	        case 2:
	        	return new StrategyDonnantDonnant();
	        case 3 : 
	        	return new StrategyAleatoire();
	        case 4 :
	        	return new StrategyDonnantDeuxDonnantAleatoire();
	        case 5 :
	        	return new StrategyDonnantDeuxDonnant();
	        case 6 :
	        	return new  StrategyDonnantDonnantSoupconneux();
	        case 7 : 
	        	return new StrategyPacificateurNaif();
	        case 8 : 
	        	return new StrategyVraiPacificateur();
	        case 9 :
	        	return new StrategyRancunier();
	        case 10 :
	        	return new StrategySondeurNaif();
	        case 11 :
	        	return new StrategySondeurRepentant();
	        case 12 : 
	        	return new StrategyVraiPacificateur();
	        case 13 : 
	        	return new StrategyAdaptatif();
	        case 14:
	        	return new StrategyPavlov();
	        case 15 :
	        	return new StrategyPavlovAleatoire();
	        case 16 :
	        	return new StrategyGraduel();
	        case 17 :  
	        	return new StrategyRancunierDoux();
	        	
	        	
	        default:
	        	return null;
	        }
	}

}
