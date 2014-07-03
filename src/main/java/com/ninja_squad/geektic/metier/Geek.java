package com.ninja_squad.geektic.metier;

public class Geek {

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private String centreInterets;
	private String gravatar;
	
	public Geek(int id, String nom, String prenom, int age, String email,
			String centreInterets, String gravatar) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
