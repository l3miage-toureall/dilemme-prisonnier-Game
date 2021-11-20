package com.dilemme.data.object;

import java.util.ArrayList;
import java.util.List;

import com.dilemme.tools.Tool.Coup;

public class Turn {
	
	private Playeur  Playeur1;
	private Playeur  Playeur2;
	private Coup decisonPlayeur1;
	private Coup decisionPlayeur2;
	private boolean hasLeavedPlayeur1 = false;
	private boolean hasLeavedPlayeur2 = false;
	
	Turn(Playeur playeur1, Playeur playeur2){
		this.Playeur1 = playeur1;
		this.Playeur2 =  playeur2;
	}
	
	public boolean getHasLeavePlayeur1() {
		return this.hasLeavedPlayeur1;
	}

	public Turn play(int idPlayeur, Coup coup) {
		if(idPlayeur == getPlayeur1().getIdPlayeur() && getPlayeur1().isHasPlayed() == false) {
			decisonPlayeur1 = coup;
			getPlayeur1().setHasPlayed(true);	
		}
		else if(idPlayeur == getPlayeur2().getIdPlayeur() && getPlayeur2().isHasPlayed() == false) {
			decisionPlayeur2 = coup;
			getPlayeur2().setHasPlayed(true);
		}
			return this;	
	}
	
	public List<Integer> getScore(){
		List <Integer> score = new ArrayList<Integer>();
		if(getDecisonPlayeur1()== Coup.TRAHIR && getDecisionPlayeur2()==Coup.COOPERER){
			score.add(5);
			score.add(0);
		}
		else if(getDecisonPlayeur1() == Coup.TRAHIR && getDecisionPlayeur2() == Coup.TRAHIR) {
			score.add(1);
			score.add(1);
			
		}
		else if(getDecisonPlayeur1() == Coup.COOPERER && getDecisionPlayeur2() == Coup.COOPERER) {
			score.add(3);
			score.add(3);
			
		}
		if(getDecisionPlayeur2()== Coup.TRAHIR && getDecisionPlayeur2()==Coup.COOPERER){
			score.add(0);
			score.add(5);
		}
		
		return score;
	}
	
	
	public String diplayScore(){
		return "Score : \n "
				+ getPlayeur1().getName()+" "+getScore().get(0)+" vs "+getScore().get(1)+" "+getPlayeur2().getName();
		
	}
	
	void play() {
		
	}
	
	public Playeur getPlayeur1() {
		return Playeur1;
	}


	public void setPlayeur1(Playeur playeur1) {
		Playeur1 = playeur1;
	}


	public Playeur getPlayeur2() {
		return Playeur2;
	}


	public void setPlayeur2(Playeur playeur2) {
		Playeur2 = playeur2;
	}


	public Coup getDecisonPlayeur1() {
		return decisonPlayeur1;
	}



	public void setDecisonPlayeur1(Coup decisonPlayeur1) {
		this.decisonPlayeur1 = decisonPlayeur1;
	}



	public Coup getDecisionPlayeur2() {
		return decisionPlayeur2;
	}



	public void setDecisionPlayeur2(Coup decisionPlayeur2) {
		this.decisionPlayeur2 = decisionPlayeur2;
	}

}
