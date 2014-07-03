package com.ninja_squad.geektic.metier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interet {
	
	@Id
	private String nomInteret;

	public Interet()
	{
		//contructeur par defaut
	}
	
	public Interet(String nomInteret) {
		super();
		this.nomInteret = nomInteret;
	}

	public String getNomInteret() {
		return nomInteret;
	}

	public void setNomInteret(String nomInteret) {
		this.nomInteret = nomInteret;
	}
	
	
}
