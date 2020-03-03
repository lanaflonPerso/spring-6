package com.ex4.springSOAP.model;

public class Chambre {
	
	private Long id;
	private int numero;
	private String typeLit;
	private Double prix;
	private Hotel hotel;
	
	
	public Long getId() {
		return id;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setTypeLit(String typeLit) {
		this.typeLit = typeLit;
	}
	public String getTypeLit() {
		return this.typeLit;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Double getPrix() {
		return this.prix;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Hotel getHotel() {
		return this.hotel;
	}
	

}
