package br.com.avenuecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avenuecode.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
