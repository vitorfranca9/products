package br.com.avenuecode.service;

import java.util.List;

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;

public interface ProductService {

	void save(ProductEntity product);

	List<ProductEntity> findAll();

	void delete(Long id);

	List<ProductEntity> findAllExcludingRelationships();

	ProductEntity findById(Long id);

	ProductEntity findByIdExcludingRelationships(Long id);

	List<ProductEntity> findProductByParentProduct(ProductEntity product);

	List<ImageEntity> findImagesByProduct(ProductEntity product);

}
