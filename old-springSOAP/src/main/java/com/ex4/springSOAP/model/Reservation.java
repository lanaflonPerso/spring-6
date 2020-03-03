package com.ex4.springSOAP.model;

import java.util.Date;

public class Reservation {
	
	private Long id;
	
	private Chambre chambre; 
	private Client client;
	private AgenceVoyage agenceVoyage;
	private Date dateDepart;
	private Date dateArrivee;
	
	
	public Long getId() {
		return id;
	}
	
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public Chambre getChambre() {
		return this.chambre;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	public Client getClient() {
		return this.client;
	}
	
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateDepart() {
		return this.dateDepart;
	}
	
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public Date getDateArrivee() {
		return this.dateArrivee;
	}
	
	
	

}
