package com.carthurnau.ProductsCategoriesMTM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carthurnau.ProductsCategoriesMTM.models.Product;
import com.carthurnau.ProductsCategoriesMTM.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
		
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
}
