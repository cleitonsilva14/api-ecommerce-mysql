package br.com.api.ecommerce.controller;


import org.springframework.web.bind.annotation.RestController;

import br.com.api.ecommerce.model.Product;
import br.com.api.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Tag(name = "Product", description = "Product endpoints")
	@Operation(summary = "Buscar todos os products", description = "Obter todos os products nesse endpoint.", tags = {"", "" })
	@ApiResponses({
			@ApiResponse(responseCode = "200",  content = { @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") }),
			// @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
	})
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
	}
	
	@Tag(name = "Product", description = "Product endpoints")
	@Operation(summary = "Buscar um product por id", description = "Obter o products por id", tags = {"", "" })
	@ApiResponses({
			@ApiResponse(responseCode = "200",  content = { @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") }),
			 @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json") })
	})
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Long id){
		Optional<Product> productOptional = productService.findById(id);
		if(!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product id " + id + " not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}
	
}
