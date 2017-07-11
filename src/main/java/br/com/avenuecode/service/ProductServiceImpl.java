package br.com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;
import br.com.avenuecode.repository.ImageRepository;
import br.com.avenuecode.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity findById(Long id) {
		return productRepository.findOneById(id);
	}

	@Override
	public ProductEntity findByIdExcludingRelationships(Long id) {
		ProductEntity product = productRepository.findOneById(id);
		resetRelationships(product);
		return product;
	}

	@Override
	public List<ProductEntity> findAllExcludingRelationships() {
		List<ProductEntity> products = productRepository.findAll();
		for (ProductEntity p : products) {
			resetRelationships(p);
		}
		return products;
	}

	@Override
	public List<ProductEntity> findProductByParentProduct(ProductEntity product) {
		return productRepository.findProductByParentProduct(product);
	}

	@Override
	public List<ImageEntity> findImagesByProduct(ProductEntity product) {
		return imageRepository.findByProduct(product);
	}

	@Override
	public void save(ProductEntity product) {
		productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

//	Bad way
	private void resetRelationships(ProductEntity product) {
		if (product != null) {
			product.setChildProducts(null);
			product.setImages(null);
			product.setParentProduct(null);
		}
	}

}
