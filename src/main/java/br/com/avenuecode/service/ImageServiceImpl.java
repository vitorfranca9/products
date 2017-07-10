package br.com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avenuecode.entity.Image;
import br.com.avenuecode.entity.Product;
import br.com.avenuecode.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public List<Image> findByProduct(Product product) {
		return imageRepository.findByProduct(product);
	}

}
