package br.com.avenuecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

	List<ImageEntity> findByProduct(ProductEntity product);

}
