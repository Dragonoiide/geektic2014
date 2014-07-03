package com.ninja_squad.geektic.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Geek {

	@Id
    @Column(name="ID")
	private long id;
	
	private String nom;
	
	private String prenom;
	
	private String sexe;
	
	private int age;
	
	private String email;
	
	private String centreInterets;
	
	private String gravatar;
	
	public Geek()
	{
		//constructeur par defaut
	}
	
	public Geek(long id, String nom, String prenom, String sexe, int age, String email,
			String centreInterets, String gravatar) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.email = email;
		this.centreInterets = centreInterets;
		this.gravatar = gravatar;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCentreInterets() {
		return centreInterets;
	}
	public void setCentreInterets(String centreInterets) {
		this.centreInterets = centreInterets;
	}
	public String getGravatar() {
		return gravatar;
	}
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
}
