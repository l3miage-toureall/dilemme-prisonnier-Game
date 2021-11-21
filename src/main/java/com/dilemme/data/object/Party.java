package com.dilemme.data.object;

import java.util.ArrayList;
import java.util.List;

import com.dilemme.strategy.Strategy;
import com.dilemme.strategy.StrategyFactory;
import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

public class Party {

	private  int id;
	private Playeur playeur1;
	private Playeur playeur2 = null;
	private boolean isJoined = false;
	private boolean playeur1HasLeave = false;
	private boolean playeur2HasLeave = false;
	private int currentTurnNumber;
	private int numberOfturns;
	private String score="";
	private Strategy strategyPlayeur1;
	private Strategy strategyPlayeur2;

	List<Coup> playeur1Coups ;
	List<Coup> playeur2Coups ;
	List<Turn> turns;
	Turn currentTurn;

	public Party(Playeur playeur, int numberOfTurn) {
		this.playeur1 = playeur;
		playeur1Coups = new ArrayList<Coup>();
		id =  Tool.randomId();
		turns = new ArrayList<Turn>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Playeur getPlayeur1() {
		return playeur1;
	}

	public void setPlayeur1(Playeur playeur1) {
		this.playeur1 = playeur1;
	}

	public Playeur getPlayeur2() {
		return playeur2;
	}

	public void setPlayeur2(Playeur playeur2) {
		this.playeur2 = playeur2;
	}

	public boolean isJoined() {
		return isJoined;
	}

	public void setJoined(boolean isJoined) {
		this.isJoined = isJoined;
	}

	public int getCurrentTurnNumber() {
		return currentTurnNumber;
	}

	public void setCurrentTurnNumber(int currentTurnNumber) {
		this.currentTurnNumber = currentTurnNumber;
	}

	public int getNumberOfturns() {
		return numberOfturns;
	}

	public void setNumberOfturns(int numberOfturns) {
		this.numberOfturns = numberOfturns;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Strategy getStrategyPlayeur1() {
		return strategyPlayeur1;
	}

	public void setStrategyPlayeur1(Strategy strategyPlayeur1) {
		this.strategyPlayeur1 = strategyPlayeur1;
	}

	public Strategy getStrategyPlayeur2() {
		return strategyPlayeur2;
	}

	public void setStrategyPlayeur2(Strategy strategyPlayeur2) {
		this.strategyPlayeur2 = strategyPlayeur2;
	}

	public List<Coup> getPlayeur1Coups() {
		return playeur1Coups;
	}

	public void setPlayeur1Coups(List<Coup> playeur1Coups) {
		this.playeur1Coups = playeur1Coups;
	}

	public List<Coup> getPlayeur2Coups() {
		return playeur2Coups;
	}

	public void setPlayeur2Coups(List<Coup> playeur2Coups) {
		this.playeur2Coups = playeur2Coups;
	}

	public List<Turn> getTurns() {
		return turns;
	}

	public void setTurns(List<Turn> turns) {
		this.turns = turns;
	}

	public Turn getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(Turn currentTurn) {
		this.currentTurn = currentTurn;
	}


	public boolean isPlayeur1HasLeave() {
		return playeur1HasLeave;
	}

	public void setPlayeur1HasLeave(boolean playeur1HasLeave) {
		this.playeur1HasLeave = playeur1HasLeave;
	}

	public boolean isPlayeur2HasLeave() {
		return playeur2HasLeave;
	}

	public void setPlayeur2HasLeave(boolean playeur2HasLeave) {
		this.playeur2HasLeave = playeur2HasLeave;
	}

	public Strategy leave(int id, Strategy strategy) {
		if(id == this.playeur1.getIdPlayeur()) {
			setPlayeur1HasLeave(true);
			strategyPlayeur2 =  strategy;
			return strategyPlayeur2;
		}
		else {
			setPlayeur2HasLeave(true);
			strategyPlayeur2 =  strategy;
			return strategyPlayeur2;
		}
	}

	public String playTurn(int id, Coup coup) { 

		if(isPlayeur2HasLeave() == false && isPlayeur1HasLeave()== false) {
			currentTurn =  currentTurn.play(id, coup);	
		}
		else if(isPlayeur2HasLeave() == true && isPlayeur1HasLeave()== false) {
			currentTurn = currentTurn.play(id, coup);
			currentTurn = currentTurn.play(this.playeur2.getIdPlayeur(), this.strategyPlayeur2.play(playeur2Coups, playeur1Coups));
		}
		else if(isPlayeur2HasLeave() == false && isPlayeur1HasLeave()== true) {
			currentTurn = currentTurn.play(id, coup);
			currentTurn = currentTurn.play(this.playeur1.getIdPlayeur(), this.strategyPlayeur1.play(playeur1Coups, playeur2Coups));

		}
		if(this.playeur1.isHasPlayed()) {
			playeur1Coups.add(this.currentTurn.getDecisonPlayeur1());
		}
		else if(this.playeur2.isHasPlayed()) {
			playeur2Coups.add(this.currentTurn.getDecisionPlayeur2());
		}

		if(this.playeur1.isHasPlayed() && this.playeur2.isHasPlayed()) {
			this.currentTurnNumber++;
			score = this.currentTurn.diplayScore();
			turns.add(currentTurn);
			currentTurn = new Turn(playeur1,playeur2);
		}
		return score;

	}
	public boolean partyIsEnd() {
		return this.currentTurnNumber == this.numberOfturns? true: false;
	}

	 public void join(Playeur playeur) {
		playeur2 = playeur;
		this.isJoined = true;
		playeur2Coups = new ArrayList<Coup>();
		currentTurn = new Turn(playeur1,playeur2);
		this.currentTurnNumber = 0;
		this.isJoined = true;
	}

	public Strategy leaveParty(Playeur playeur, int idStrategy) {
		if(playeur.getName() == this.playeur1.getName()) {
			this.playeur1 = null;
			this.setPlayeur1HasLeave(true);
			return chooseStrategy(idStrategy);
		}
		else {
			this.playeur2 = null;
			this.setPlayeur2HasLeave(true);
			return chooseStrategy(idStrategy);
		}
	}

	private Strategy chooseStrategy(int idStrategy) {
		return StrategyFactory.getInstance(idStrategy);
	}
}
