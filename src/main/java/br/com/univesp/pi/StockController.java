package br.com.univesp.pi;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class StockController {

    @Autowired
    ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/api/products")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){

        // Convert DTO to Entity
        Product productRequest = modelMapper.map(productDTO, Product.class);

        // Save Product to MySQL
        Product product = productService.saveProduct(productRequest);

        // Convert Entity to DTO
        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);

        return new ResponseEntity<ProductDTO>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Long id) {

        // Get Product from MySQL
        Product product = productService.getProductById(id);

        // Convert Entity to DTO
        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);

        return ResponseEntity.ok().body(productResponse);
    }


    @GetMapping("/api/product/jarvis/{name}")
    public ResponseEntity<List<Product>> getProductByRegex(@PathVariable(name = "name") String name) {

        // Get Product from MySQL
        List<Product> products = productService.getProductByRegex(name);

        return ResponseEntity.ok().body(products);
    }

}