package com.javacode.sinatrends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.entity.Category;
import com.javacode.sinatrends.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category createCategory(Category categoryResponse) {
		if(categoryRepo.findBySlug(categoryResponse.getSlug()).isPresent()) {
			throw new RuntimeException("Slug already exicist");
		}
		Category category =categoryRepo.save(categoryResponse);
		return category;
	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> Categorise = categoryRepo.findAll();
		return Categorise;
	}

	public Category updateCategory(String category_slug, Category updtateCategoryItems) {
		// TODO Auto-generated method stub
		Category category =  categoryRepo.findBySlug(category_slug).orElseThrow(()-> new RuntimeException("Category not found by this "+category_slug));
		category.setName(updtateCategoryItems.getName());
		category.setSlug(updtateCategoryItems.getSlug());
		category.setActive(updtateCategoryItems.getActive());
		
		if(categoryRepo.findBySlug(updtateCategoryItems.getSlug()).isPresent()) {
			throw new RuntimeException("Slug already exicist");
		}
		return categoryRepo.save(category);
	}
}
