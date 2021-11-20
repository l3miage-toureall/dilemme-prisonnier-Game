package com.dilemme.strategy;

import java.util.List;

import com.dilemme.tools.Tool.Coup;

public interface Strategy {

	public Coup play(List<Coup> playeur1ListOfCoups, List<Coup> playeur2ListofCoups) ;
}
