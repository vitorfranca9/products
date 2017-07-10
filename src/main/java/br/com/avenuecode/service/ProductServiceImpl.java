package br.com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avenuecode.entity.Product;
import br.com.avenuecode.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		Product product = productRepository.findOneById(id);
		return product;
	}

	@Override
	public Product findByIdExcludingRelationships(Long id) {
		Product product = productRepository.findOneById(id);
//		Bad way
		if (product != null) {
//			Hibernate.initialize(p.getChildProducts());
			product.setChildProducts(null);
//			Hibernate.initialize(p.getImages());
			product.setImages(null);
		}
		return product;
	}

	@Override
	public List<Product> findAllExcludingRelationships() {
		List<Product> products = productRepository.findAll();
//		Bad way
		for (Product p : products) {
//			Hibernate.initialize(p.getChildProducts());
			p.setChildProducts(null);
//			Hibernate.initialize(p.getImages());
			p.setImages(null);
		}
		return products;
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
