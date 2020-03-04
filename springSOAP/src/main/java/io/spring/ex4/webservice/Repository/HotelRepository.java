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
		Hotel h1 = new Hotel();
		h1.setId(1);
		h1.setNom("Hotel A");
		h1.setNombreEtoiles(5);
		h1.setNombreLits(70);
		h1.setAdresse(new Adresse(1, "France", "Montpellier", "rue commedie",125, "43.607505, 3.883095"));
		List<Chambre> listC = new ArrayList<Chambre>();
		listC.add(new Chambre(1, 50, "lit simple", 14.32));
		listC.add(new Chambre(2, 10, "lit double", 14.32));
		listC.add(new Chambre(3, 123, "lit simple", 14.32));
		h1.setChambre(listC);
		

		hotels.put(h1.getId(), h1);

		Hotel h2 = new Hotel();
		h2.setId(2);
		h2.setNom("Hotel B");
		h2.setNombreEtoiles(3);
		h2.setNombreLits(50);
		h2.setAdresse(new Adresse(1, "France", "Montpellier", "rue strasbourg",125, "42.501405, 9.543654"));
		List<Chambre> listC2 = new ArrayList<Chambre>();
		listC2.add(new Chambre(4, 50, "lit double", 40.87));
		listC2.add(new Chambre(5, 65, "lit simple", 54.10));
		listC2.add(new Chambre(6, 73, "lit double", 30.00));
		h2.setChambre(listC);
		

		hotels.put(h2.getId(), h2);

		Hotel h3 = new Hotel();
		h3.setId(3);
		h3.setNom("Hotel C");
		h3.setNombreEtoiles(4);
		h3.setNombreLits(120);
		h3.setAdresse(new Adresse(1, "France", "Perpignan", "rue faubourg",125, "15.508075, 8.656453"));
		List<Chambre> listC3 = new ArrayList<Chambre>();
		listC3.add(new Chambre(7, 54, "lit simple", 20.47));
		listC3.add(new Chambre(8, 97, "lit double", 43.00));
		listC3.add(new Chambre(9, 32, "lit double", 50.00));
		h3.setChambre(listC);
		
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
						if(ch.getPrix()>= minPrix && ch.getPrix() <= maxPrix) {
							listCh.add(ch);
						}
					}
					
				   listH.add(new Hotel(h.getId(), h.getNom(), h.getNombreEtoiles(), h.getAdresse(), listCh));
				}
				
			}
		}
		return listH;
	}
}
