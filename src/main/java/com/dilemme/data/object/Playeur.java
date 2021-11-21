package com.dilemme.data.object;


import com.dilemme.tools.Tool;
import com.dilemme.tools.Tool.Coup;

public class Playeur {
	
	private int idPlayeur;
	private String name;
	private boolean hasPlayed = false;
	
	
	public Playeur(String name){
		this.name =  name;
		idPlayeur = Tool.randomId();
	}
	
	
	


	public int getIdPlayeur() {
		return idPlayeur;
	}

	public String getName() {
		return name;
	}

	public boolean isHasPlayed() {
		return hasPlayed;
	}


	public void setHasPlayed(boolean hasPlayed) {
		this.hasPlayed = hasPlayed;
	}

	

}
