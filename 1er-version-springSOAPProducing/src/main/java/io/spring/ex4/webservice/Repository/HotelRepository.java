package io.spring.ex4.webservice.Repository;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.ex4.webservice.Adresse;
import io.spring.ex4.webservice.Chambre;
import io.spring.ex4.webservice.Hotel;

@Component
public class HotelRepository {
	
	private static final Map<Integer, Hotel> hotels = new HashMap<>();

	@PostConstruct
	public void initData() {
		
		//HOTEL 1
		Hotel h1 = new Hotel();
		h1.setId(1);
		h1.setNom("Hotel A");
		h1.setNombreEtoiles(5);
		h1.setNombreLits(70);
		Adresse ad1 = new Adresse();
		ad1.setId(1); ad1.setPays("France"); ad1.setVile("Paris"); ad1.setRue("rue comédie"); ad1.setNumero(125); ad1.setPositionGPS("43.607505, 3.883095");
		h1.setAdresse(ad1);
		List<Chambre> listC1 = new ArrayList<Chambre>();
		Chambre ch11 = new Chambre();
		ch11.setId(1); ch11.setNumero(50); ch11.setTypeLit("lit simple"); ch11.setPrix(19.34); ch11.setDisponible("yes");
		Chambre ch12 = new Chambre();
		ch12.setId(2); ch12.setNumero(10); ch12.setTypeLit("lit double"); ch12.setPrix(25.50); ch12.setDisponible("yes");
		Chambre ch13 = new Chambre();
		ch13.setId(3); ch13.setNumero(80); ch13.setTypeLit("lit simple"); ch13.setPrix(20.00); ch13.setDisponible("no");
		listC1.add(ch11);
		listC1.add(ch12);
		listC1.add(ch13);
		h1.getChambre().addAll(listC1);
		hotels.put(h1.getId(), h1);
		
		//HOTEL 2

		Hotel h2 = new Hotel();
		h2.setId(2);
		h2.setNom("Hotel B");
		h2.setNombreEtoiles(3);
		h2.setNombreLits(50);
		Adresse ad2 = new Adresse();
		ad2.setId(2); ad2.setPays("France"); ad2.setVile("Montpellier"); ad2.setRue("rue faubourg"); ad2.setNumero(118); ad2.setPositionGPS("42.501405, 9.543654");
		h2.setAdresse(ad2);
		List<Chambre> listC2 = new ArrayList<Chambre>();
		Chambre ch21 = new Chambre();
		ch21.setId(4); ch21.setNumero(51); ch21.setTypeLit("lit simple"); ch21.setPrix(40.20); ch21.setDisponible("no");
		Chambre ch22 = new Chambre();
		ch22.setId(5); ch22.setNumero(65); ch22.setTypeLit("lit simple"); ch22.setPrix(45.99); ch22.setDisponible("yes");
		Chambre ch23 = new Chambre();
		ch23.setId(6); ch23.setNumero(71); ch23.setTypeLit("lit double"); ch23.setPrix(30.00); ch23.setDisponible("yes");
		//ajouter chambres à la liste de chambres
		listC2.add(ch21);
		listC2.add(ch22);
		listC2.add(ch23);
		//ajouter chambres à l'hotel
	    h2.getChambre().addAll(listC2);
		hotels.put(h2.getId(), h2);
		
		
		// HOTEL 3
		Hotel h3 = new Hotel();
		h3.setId(3);
		h3.setNom("Hotel C");
		h3.setNombreEtoiles(4);
		h3.setNombreLits(120);
		Adresse ad3 = new Adresse();
		ad3.setId(3); ad3.setPays("France"); ad3.setVile("Perpignan"); ad3.setRue("rue Coluche"); ad3.setNumero(20); ad3.setPositionGPS("15.508075, 8.656453");
		h3.setAdresse(ad3);
		
		List<Chambre> listC3 = new ArrayList<Chambre>();
		Chambre ch31 = new Chambre();
		ch31.setId(7); ch31.setNumero(54); ch31.setTypeLit("lit simple"); ch31.setPrix(70.99); ch31.setDisponible("yes");
		Chambre ch32 = new Chambre();
		ch32.setId(8); ch32.setNumero(81); ch32.setTypeLit("lit double"); ch32.setPrix(75.99); ch32.setDisponible("no");
		Chambre ch33 = new Chambre();
		ch33.setId(9); ch33.setNumero(32); ch33.setTypeLit("lit double"); ch33.setPrix(60.00); ch33.setDisponible("yes");
		listC3.add(ch31);
		listC3.add(ch32);
		listC3.add(ch33);
		h3.getChambre().addAll(listC3);
		
		hotels.put(h3.getId(), h3);
	}

	public List<Hotel> findHotel(String nom, Date dateDepart, Date dateArrive, String intervallePrix, int nombreEtoiles, int nombresPersonnesHeberges) {
		Assert.notNull(nom, "The hotel name must not be null");		
		String [] prix = intervallePrix.split("-");
		Double minPrix = Double.parseDouble(prix[0]);
		Double maxPrix = Double.parseDouble(prix[1]);
		
		List<Hotel> listH = new ArrayList<Hotel>();
		List<Chambre> listCh = new ArrayList<Chambre>();
		for(Hotel h: hotels.values()) {
			if(h.getAdresse().getVile().equals(nom) && h.getNombreEtoiles() == nombreEtoiles) {
				if(h.getChambre().size()>= nombresPersonnesHeberges) {
					for(Chambre ch: h.getChambre()) {
						//tester la disponibilité, et l'intervalle de prix demandé par le client.
						if(ch.getDisponible().equals("yes") && ch.getPrix()>= minPrix && ch.getPrix() <= maxPrix) {
							listCh.add(ch);
						}
					}
					
					Hotel hFound = new Hotel();
					hFound.setId(h.getId());
					hFound.setNom(h.getNom());
					hFound.setNombreEtoiles(h.getNombreEtoiles());
					hFound.setAdresse(h.getAdresse());
					hFound.getChambre().addAll(listCh);
					// ajouter les chambre et l'hotel qui répondent aux critères à liste des offres à retoruner au client.
				    listH.add(hFound);
				}
				
			}
		}
		return listH;
	}
}
