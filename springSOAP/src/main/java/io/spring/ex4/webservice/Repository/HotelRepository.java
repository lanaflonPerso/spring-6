package io.spring.ex4.webservice.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.ex4.webservice.Hotel;

@Component
public class HotelRepository {
	private static final Map<Integer, Hotel> countries = new HashMap<>();

	@PostConstruct
	public void initData() {
		Hotel h1 = new Hotel();
		h1.setId(1);
		h1.setNom("Hotel A");
		

		countries.put(h1.getId(), h1);

		Hotel h2 = new Hotel();
		h2.setId(2);
		h2.setNom("Hotel B");
		

		countries.put(h2.getId(), h2);

		Hotel h3 = new Hotel();
		h3.setId(3);
		h3.setNom("Hotel C");

		countries.put(h3.getId(), h3);
	}

	public Hotel findHotel(String nom) {
		Assert.notNull(nom, "The hotel name must not be null");
		return countries.get(1);
	}
}
