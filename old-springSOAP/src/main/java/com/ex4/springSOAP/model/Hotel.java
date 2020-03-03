package com.ex4.springSOAP.model;

public class Hotel {
	private Long id;
	private String nom;
	private Adresse adresse;
	private int nombreEtoiles;
	private int nombreLits;
	
	public Long getId() {
		return id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Adresse getAdresse() {
		return this.adresse;
	}
	
	public void setNombreEtoiles(int nombreEtoiles) {
		this.nombreEtoiles = nombreEtoiles;
	}
	public int getNombreEtoiles() {
		return this.nombreEtoiles;
	}
	
	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}
	public int getNombreLits() {
		return this.nombreLits;
	}
	

}
