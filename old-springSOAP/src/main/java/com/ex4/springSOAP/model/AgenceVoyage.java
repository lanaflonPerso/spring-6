package com.ex4.springSOAP.model;

public class AgenceVoyage {
	
	private Long id;
	private String nom;
	private Double tarif;
	
	public Long getId() {
		return id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	public Double getTarif() {
		return this.tarif;
	}

}
