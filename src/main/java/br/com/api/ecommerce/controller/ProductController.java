package br.com.api.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.ecommerce.model.Product;
import br.com.api.ecommerce.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Tag(name = "Product")
	@Operation(
		summary = "Get all products",
		description = "Buscar todos os produtos"
	)
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
	}
	
	@Tag(name = "Product")
	@Operation(
		summary = "Get product by id",
		description = "Buscar produto pelo id"
	)
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id){
		return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
	}
	
	
	@Tag(name = "Product")
	@Operation(
			summary = "Save a new product",
			description = "Salvar um novo produto"
		)
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}
	
	@Tag(name = "Product")
	@Operation(
			summary = "Save many new products",
			description = "Salvar uma lista de produtos"
	)
	
	@PostMapping("/saveall")
	public ResponseEntity<?> saveAllProducts(@RequestBody List<Product> products){
		return new ResponseEntity<>(productRepository.saveAll(products), HttpStatus.CREATED);
	}
	
	@Tag(name = "Product")
	@Operation(
			summary = "Update a product",
			description = "Atualizar as informações do produto passando o seu id"
	)
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product){
		var productOld = productRepository.findById(id).get();
		productOld.setActive(product.getActive());
		productOld.setName(product.getName());
		productOld.setDescription(product.getDescription());
		productOld.setPrice(product.getPrice());
		return new ResponseEntity<>(productRepository.save(productOld), HttpStatus.OK);
		
	}
	@Tag(name = "Product")
	@Operation(
			summary = "Delete a product",
			description = "Deletar um produto passando o seu id"
	)
	@DeleteMapping("/delete/{id}")
	public void deleteProductById(@PathVariable Long id){
		productRepository.deleteById(id);
	}
	
	
	
	
	
}
