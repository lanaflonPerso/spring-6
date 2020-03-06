package io.spring.ex4.webservice.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.ex4.webservice.Adresse;
import io.spring.ex4.webservice.AgenceVoyage;
import io.spring.ex4.webservice.Chambre;
import io.spring.ex4.webservice.Client;
import io.spring.ex4.webservice.Offre;

@Component
public class ReservationRepository {
	private List<String> confirmation = new ArrayList<String>();
	private List<AgenceVoyage> agencesVoyages = new ArrayList<AgenceVoyage>();
	
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
	}

	public List<String>  confirmerReservation(String login,  String password, String idOffre, Client client) {
		/* validation des données reçus par le web service 2 */
		Assert.notNull(login, "Le login  de l'agence de voyage doit être non null");
		Assert.notNull(password, "Le password de l'agence de voyage doit être non null");
		
		System.out.println("****************************************");
		/* verifier si l'agence de voyage qui demande le service web existe dans la base de données de l'hote */
		for(AgenceVoyage ag: agencesVoyages) {
			if(ag.getLogin().equals(login) && ag.getPassword().equals(password)) {
				
				confirmation.add("Reservation  été bien faite.");
				confirmation.add(idOffre);
				System.out.println("Reservation  été bien faite.");
			}
		}
		return confirmation;
	}
}
