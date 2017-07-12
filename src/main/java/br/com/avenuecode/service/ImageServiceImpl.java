package br.com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;
import br.com.avenuecode.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public void save(ImageEntity image) {
		imageRepository.save(image);
	}

	@Override
	public void delete(Long id) {
		imageRepository.delete(id);
	}
	
	@Override
	public ImageEntity findById(Long id) {
		return imageRepository.findOneById(id);
	}

	@Override
	public List<ImageEntity> findByProduct(ProductEntity product) {
		return imageRepository.findByProduct(product);
	}

}
