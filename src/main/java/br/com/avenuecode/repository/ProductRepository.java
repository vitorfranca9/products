package br.com.avenuecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avenuecode.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Product findOneById(Long id);
	
//	@SuppressWarnings("rawtypes")
//	public List<Product> findByImagesAndChildProducts(List images, List products);
	
//	public List<Product> findByImages(List images);
	
//	public List<Product> findByChildProducts(List products);

}
