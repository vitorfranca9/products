package br.com.avenuecode.service;

import java.util.List;

import br.com.avenuecode.entity.Image;
import br.com.avenuecode.entity.Product;

public interface ImageService {

	public List<Image> findByProduct(Product product);

}
