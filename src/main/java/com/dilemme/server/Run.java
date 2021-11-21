package com.dilemme.server;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilemme.data.object.Party;
import com.dilemme.data.object.Playeur;
import com.dilemme.tools.Tool;

@CrossOrigin
@RestController
@RequestMapping("/")
public class Run {
	
	List<Playeur> playeurs = new ArrayList<Playeur>();
	List<Party> partys = new ArrayList<Party>();
	
	@GetMapping("/")
	public String welcome(){
	    return "Please come later the web site is in building ! (- ";
	}
	
	@GetMapping("/{playeurName}")
	boolean createPlayeur(@PathVariable(value="playeurName") String name) {
		Playeur playeur = new Playeur(name);
		playeurs.add(playeur);
		return true;	
	}
	@GetMapping("/newParty/{numberOfTun}&{nomPlayeur}")
	boolean createParty(@PathVariable(value="numberOfTurn")  int number, @PathVariable( value="nomPlayeur") String name) {
		boolean created = false;
		Playeur playeur = Tool.getPlayeur(playeurs, name);
		if(playeur.getName() != "") {
			Party party = new Party(playeur,number);
			created = true;
			partys.add(party);
			
		}	
		return created;
	}
	
	@GetMapping("/joinParty/{idParty}&{playeurName}")
	boolean joinParty(@PathVariable(value="idParty") int idParty, @PathVariable(value="playeurName") String name) {
		boolean isJoinned = false;
		Party party = Tool.getParty(partys, idParty);
		Playeur playeur = Tool.getPlayeur(playeurs, name);
		if(party.getPlayeur1()!=null && playeur.getName() !="") {
			party.join(playeur);
			isJoinned = true;
		}
		return isJoinned;
	}
	
	@GetMapping("/play/{playeurName}&{coup}&{idParty}")
	boolean play(@PathVariable(value="playeurName") String name, @PathVariable(value="coup") String coup, @PathVariable(value="idParty") int idParty) {
		boolean hasPlayed = false;
		Playeur playeur = Tool.getPlayeur(playeurs, name);
		Party party = Tool.getParty(partys, idParty);
		if(playeur.getName() != "" && party.getPlayeur1() != null) {
			if(coup == "coopérer") {
				party.getCurrentTurn().play(playeur.getIdPlayeur(), Tool.Coup.COOPERER);
			    hasPlayed = true;	
			}
			else {
				party.getCurrentTurn().play(playeur.getIdPlayeur(), Tool.Coup.TRAHIR);
			    hasPlayed = true;
			}
		}
		return hasPlayed;
	}
	
	@GetMapping("/leave/{idParty}&{playeurName}&{idStrategy}")
	boolean leave(@PathVariable(value="idParty") int idParty, @PathVariable(value="playeurName") String name, @PathVariable(value="idStrategy") int idStrategy) {
		boolean hasLeaved = false;
		Party party = Tool.getParty(partys, idParty);
		Playeur playeur = Tool.getPlayeur(playeurs, name);
		if(playeur.getName() != "" && party.getPlayeur1() != null) {
			party.leaveParty(playeur,idStrategy);
			hasLeaved = true;
		}
		
		
		return hasLeaved;
	}
	
	

}
