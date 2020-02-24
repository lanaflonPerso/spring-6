package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	
	public List<Product> findAll();
	public Product findById(int id);
	public Product save(Product product); 

}
