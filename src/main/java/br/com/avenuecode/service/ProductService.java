package br.com.avenuecode.service;

import java.util.List;

import br.com.avenuecode.entity.Product;

public interface ProductService {

	void save(Product product);

	List<Product> findAll();

	void delete(Long id);

	List<Product> findAllExcludingRelationships();

	Product findById(Long id);

	Product findByIdExcludingRelationships(Long id);

}
