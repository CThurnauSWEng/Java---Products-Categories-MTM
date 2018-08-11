package com.carthurnau.ProductsCategoriesMTM.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carthurnau.ProductsCategoriesMTM.models.Category;
import com.carthurnau.ProductsCategoriesMTM.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
}
