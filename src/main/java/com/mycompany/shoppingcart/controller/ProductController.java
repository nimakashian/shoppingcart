package com.mycompany.shoppingcart.controller;


import com.mycompany.shoppingcart.domain.Product;
import com.mycompany.shoppingcart.repoaitory.ProductRepository;
import com.mycompany.shoppingcart.validation.ProductValidationError;
import com.mycompany.shoppingcart.validation.ProductValidationErrorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping("/showcase")
public class ProductController {

    private ProductRepository productShopRepository;

    @Autowired
    public ProductController(ProductRepository productShopRepository) {
        this.productShopRepository = productShopRepository;
    }

    @GetMapping("/product")
    public ResponseEntity<Iterable<Product>> getProducts() {
        return ResponseEntity.ok(productShopRepository.findAll());

    }

    @GetMapping("/product/{pcode}")
    public ResponseEntity<Product> getProductByPcode(@PathVariable String pcode) {
        Optional<Product> product = productShopRepository.findByPcode(pcode);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/product/{pcode}")
    public ResponseEntity<Product> setExpired(@PathVariable String pcode) {
        Optional<Product> product = productShopRepository.findByPcode(pcode);
        if (!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Product result = product.get();
        result.setExpire(LocalDateTime.now());
        productShopRepository.save(result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.ok().header("Location", location.toString()).build();
    }

    //TODO ? json input
    @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ProductValidationErrorBuilder.fromBindingErrors(errors));

        }
        Product result = productShopRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pcode}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/product/{pcode}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String pcode) {
        productShopRepository.delete(productShopRepository.findByPcode(pcode).get());
        return ResponseEntity.noContent().build();
    }

    //TODO multiple status ?
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ProductValidationError handleError(Exception e) {
        return new ProductValidationError(e.getMessage());
    }


}
