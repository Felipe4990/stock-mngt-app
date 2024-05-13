package br.com.univesp.pi;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class StockController {

    @Autowired
    ProductService productService;

    @Autowired
    private ModelMapper modelMapper;
    @CrossOrigin
    @PostMapping(path = "/api/products")
    public ResponseEntity<ProductDTO> saveMaterial(@RequestBody ProductDTO productDTO){

        // Convert DTO to Entity
        Product productRequest = modelMapper.map(productDTO, Product.class);

        // Save Product to MySQL
        Product product = productService.saveProduct(productRequest);

        // Convert Entity to DTO
        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);

        return new ResponseEntity<ProductDTO>(productResponse, HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping("/api/product/id/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(name = "id") Long id) {

        // Delete Material from MySQL
        productService.deleteProductById(id);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/api/product/id/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Long id) {

        // Get Product from MySQL
        Product product = productService.getProductById(id);

        // Convert Entity to DTO
        ProductDTO productResponse = modelMapper.map(product, ProductDTO.class);

        return ResponseEntity.ok().body(productResponse);
    }

    @CrossOrigin
    @GetMapping("/api/product/{productName}")
    public ResponseEntity<List<Product>> getProductsNameByRegex(@PathVariable(name = "productName") String name) {

        // Get Product from MySQL
        List<Product> products = productService.getProductsNamesByRegex(name);

        return ResponseEntity.ok().body(products);
    }



}