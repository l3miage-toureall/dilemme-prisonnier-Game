package com.dilemme.data.object;


import com.dilemme.tools.Tool.Coup;

public class Playeur {
	
	private String name;
	public String getName() {
		return name;
	}

	private Coup decision;
	
	Playeur(String name){
		this.name =  name;
	}
	
	Coup giveDecision(){
		return decision;
	}
	
	void createParty() {
		
	}
	void joinParty(int idParty) {
		
	}

	public Coup getDecision() {
		return decision;
	}

	public void setDecision(Coup decision) {
		this.decision = decision;
	}

}
