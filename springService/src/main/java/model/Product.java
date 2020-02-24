package model;

public class Product {
	
	private int id;
	private String nom;
	private int prix;
	
	public Product() {}
	
	public Product(int id, String nom, int prix){
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	} 
	
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getPrix() {
		return this.prix;
	}
	
	@Override
	public String toString() {
		return "Product {"
				+ "id="+id
				+"nom="+nom+
				"prenom="+prix 
				+ "} ";
	}

}
