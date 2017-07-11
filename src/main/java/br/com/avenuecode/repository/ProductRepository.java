package br.com.avenuecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avenuecode.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	ProductEntity findOneById(Long id);

	List<ProductEntity> findProductByParentProduct(ProductEntity product);

}
