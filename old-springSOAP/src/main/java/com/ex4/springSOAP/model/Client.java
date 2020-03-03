package com.ex4.springSOAP.model;


public class Client {
	
	private Long id;
	private String nom;
	private String prenom;
	private String carteCredit;
	
	public Long getId() {
		return id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setCarteCredit(String carteCredit) {
		this.carteCredit = carteCredit;
	}
	public String getCarteCredit() {
		return this.carteCredit;
	}

}
