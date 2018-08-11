package com.carthurnau.ProductsCategoriesMTM.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carthurnau.ProductsCategoriesMTM.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findAll();
	
}
