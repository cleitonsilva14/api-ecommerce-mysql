package br.com.api.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
