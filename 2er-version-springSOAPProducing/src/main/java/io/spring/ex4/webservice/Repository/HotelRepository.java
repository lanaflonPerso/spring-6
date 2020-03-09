package io.spring.ex4.webservice.Repository;

import javax.annotation.PostConstruct;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.ex4.webservice.Adresse;
import io.spring.ex4.webservice.AgenceVoyage;
import io.spring.ex4.webservice.Chambre;
import io.spring.ex4.webservice.Hotel;
import io.spring.ex4.webservice.Offre;

@Component
public class HotelRepository {
	
	private Hotel hotel = new Hotel();
	private List<Chambre> listChambres = new ArrayList<Chambre>();
	private List<AgenceVoyage> agencesVoyages = new ArrayList<AgenceVoyage>();
	private List<Offre>  offres = new ArrayList<Offre>();

	@PostConstruct
	public void initData() {
		
		
		/***************************************************************
		 ****************** Liste des agences de voyages ***************
		 ***************************************************************/
		AgenceVoyage ag1 = new AgenceVoyage();
		ag1.setId(1); ag1.setLogin("karim"); ag1.setPassword("dahdouh"); ag1.setNom("Lundi au soleil"); ag1.setTarif(7.50);
		AgenceVoyage ag2 = new AgenceVoyage();
		ag2.setId(2); ag2.setLogin("theirno"); ag2.setPassword("barry");ag2.setNom("take your breath"); ag2.setTarif(09.00);
		agencesVoyages.add(ag1);
		agencesVoyages.add(ag2);
		
		/***************************************************************
		 ************************ Liste des hotels *********************
		 ***************************************************************/
		
		//HOTEL 1
		hotel.setId(1);
		hotel.setNom("Hotel A");
		hotel.setNombreEtoiles(5);
		hotel.setNombreLits(70);
		Adresse ad1 = new Adresse();
		ad1.setId(1); ad1.setPays("France"); ad1.setVile("Paris"); ad1.setRue("rue comédie"); ad1.setNumero(125); ad1.setPositionGPS("43.607505, 3.883095");
		hotel.setAdresse(ad1);

		Chambre ch11 = new Chambre();
		ch11.setId(1); ch11.setNumero(50); ch11.setTypeLit("lit simple"); ch11.setPrix(60.34); ch11.setDisponible("yes");
		Chambre ch12 = new Chambre();
		ch12.setId(2); ch12.setNumero(10); ch12.setTypeLit("lit double"); ch12.setPrix(80.50); ch12.setDisponible("yes");
		Chambre ch13 = new Chambre();
		ch13.setId(3); ch13.setNumero(80); ch13.setTypeLit("lit simple"); ch13.setPrix(91.00); ch13.setDisponible("no");
		listChambres.add(ch11);
		listChambres.add(ch12);
		listChambres.add(ch13);
		//ajouter chambres à l'hotel
		hotel.getChambre().addAll(listChambres);
		 
	}

	public List<Offre>  findHotel(String login,  String password, String dateDebut, String dateFin, int nombrePersonnesHeberges) {
		Assert.notNull(login, "Le login  de l'agence de voyage doit être non null");
		Assert.notNull(password, "Le password de l'agence de voyage doit être non null");
		//Date dateD = new Date(dateDebut);
		//Date dateF = new Date(dateFin);
		
		//verifier si l'agence de voyage qui demande le service web existe dans la base de données de l'hotel.
		for(AgenceVoyage ag: agencesVoyages) {
						if(ag.getLogin().equals(login) && ag.getPassword().equals(password)) {
								
				if (hotel.getChambre().size() >= nombrePersonnesHeberges) {
					for (Chambre ch : hotel.getChambre()) {
						// tester la disponibilité, et l'intervalle de prix demandé par le client.
						if (ch.getDisponible().equals("yes")) {
							Offre offr = new Offre();
							//identifiant de l'offre est le numéro de chambre concaténer avec la date d'oujourd'hui
							offr.setId(ch.getNumero()+"_"+ new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
							offr.setDateDisponibilite("05-03-2020");
							offr.setTypeChambre(ch.getTypeLit());
							offr.setPrix((ag.getTarif()*ch.getPrix())/100);
							/* ajouter les chambre disponibles aux offres  de l'hotel. 
							 * Cette liste des offres sera renvoyer au client comme résultat du service web.
							 */
							offres.add(offr);
						}
					}					
				}
			}
		}
		

		return offres;
	}
}
