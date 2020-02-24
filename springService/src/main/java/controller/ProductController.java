package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.ProductDao;
import model.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	@GetMapping(path="/products")
	public List<Product> lisProduits(){
		return productDao.findAll();
	}
	
	//produits/{id}
	@GetMapping(path="/products/{id}")
	public Product afficherProduit(@PathVariable int id) {
		return productDao.findById(id);
	}
	
	@PostMapping(path="/products/add")
	public void addProduct(@RequestBody Product product) {
		productDao.save(product);
	}

}
