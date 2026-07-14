package com.javacode.sinatrends.spec;



import org.springframework.data.jpa.domain.Specification;

import com.javacode.sinatrends.entity.Category;
import com.javacode.sinatrends.entity.Product;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

public class ProductSpecification {
	public static Specification<Product> hasNameOrDescriptionLike(String keyword) {
		return (root, query, cb) -> {
			if(keyword == null || keyword.trim().isEmpty()) {
				return cb.conjunction();
			}
			
			String searchKeyword = "%"+keyword.toLowerCase().trim()+"%";
			Join<Category, Product> categoryJoin = root.join("category", JoinType.LEFT);
			
			
			
			return cb.or(
					cb.like(cb.lower(root.get("name")), searchKeyword),
					cb.like(cb.lower(root.get("description")), searchKeyword),
					cb.like(cb.lower(categoryJoin.get("name")), searchKeyword)
			);
		};
	}
	
	public static Specification<Product> hasAvailability(Integer availability){
		return (root,query,cb) -> {
			if(availability == null) {
				return cb.conjunction();
			}
			if(availability == 1) {
				return cb.greaterThan(root.get("stock"), 0);
			}
			if(availability == 0) {
				return cb.equal(root.get("stock"), 0);
			}
			return cb.conjunction();
		};
		
		
	}
	
	public static Specification<Product> priceBetween(Double min, Double max){
		return (root,query,cb) -> {
			if(min == null && max == null) {
				return null;
			}
			if(min == null) return cb.lessThanOrEqualTo(root.get("salePrice"), max);
			if(max == null) return cb.greaterThanOrEqualTo(root.get("salePrice"), min);
			return cb.between(root.get("salePrice"), min, max);
		};
		
	}
}
