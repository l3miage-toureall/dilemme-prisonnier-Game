package com.dilemme.data.object;

import java.util.ArrayList;
import java.util.List;

import com.dilemme.tools.Tool.Coup;

public class Turn {
	
	private String namePlayeur1;
	private String namePlayeur2;
	
	private Coup decisonPlayeur1;
	private Coup decisionPlayeur2;

	Turn(String name1, String name2 ){
		namePlayeur1 = name1;
		namePlayeur2 = name2;
	}
	
	
	public List<Integer> getScore(){
		List <Integer> score = new ArrayList<Integer>();
		if(getDecisonPlayeur1()== Coup.Trahir && getDecisionPlayeur2()==Coup.Cooperer){
			score.add(5);
			score.add(0);
		}
		else if(getDecisonPlayeur1() == Coup.Trahir && getDecisionPlayeur2() == Coup.Trahir) {
			score.add(1);
			score.add(1);
			
		}
		else if(getDecisonPlayeur1() == Coup.Cooperer && getDecisionPlayeur2() == Coup.Cooperer) {
			score.add(3);
			score.add(3);
			
		}
		if(getDecisionPlayeur2()== Coup.Trahir && getDecisionPlayeur2()==Coup.Cooperer){
			score.add(0);
			score.add(5);
		}
		
		return score;
	}
	
	
	public String diplayScore(){
		return "Score : \n "
				+ getNamePlayeur1()+" "+getScore().get(0)+" vs "+getScore().get(1)+" "+getNamePlayeur2();
		
	}



	public String getNamePlayeur1() {
		return namePlayeur1;
	}

	public String getNamePlayeur2() {
		return namePlayeur2;
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
