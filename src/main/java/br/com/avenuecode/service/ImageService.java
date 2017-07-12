package br.com.avenuecode.service;

import java.util.List;

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;

public interface ImageService {

	void save(ImageEntity image);

	void delete(Long id);

	List<ImageEntity> findByProduct(ProductEntity product);

	ImageEntity findById(Long id);

}
