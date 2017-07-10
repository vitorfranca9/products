package br.com.avenuecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avenuecode.entity.Image;
import br.com.avenuecode.entity.Product;

public interface ImageRepository extends JpaRepository<Image, Long> {

	public List<Image> findByProduct(Product product);

}
