package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public class ProudctDaoImpl implements ProductDao {

	public static List<Product> products = new ArrayList<>();
	
	static {
		products.add(new Product(2, "Appareil photo", 356));
		products.add(new Product(3, "table de Ping Ping", 620));
		products.add(new Product(4, "laverie", 720));
	}
	
	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public Product findById(int id) {
		for(Product product: products) {
			if(product.getId() == id) {
				return product;
			}
		}
		
		return null;
	}

	@Override
	public Product save(Product product) {
		products.add(product);
		return product;
	}

}
