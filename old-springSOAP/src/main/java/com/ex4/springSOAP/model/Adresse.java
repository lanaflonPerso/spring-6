package com.ex4.springSOAP.model;

public class Adresse {
	private Long id;
	private String pays;
	private String ville;
	private String rue;
	private String numero;
	private String positionGPS;
	
	
	public Long getId() {
		return id;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getPays() {
		return this.pays;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getVille() {
		return this.ville;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getRue() {
		return this.rue;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumero() {
		return this.numero;
	}
	
	public void setPositionGPS(String positionGPS) {
		this.positionGPS = positionGPS;
	}
	public String getPositionGPS() {
		return this.positionGPS;
	}

}
