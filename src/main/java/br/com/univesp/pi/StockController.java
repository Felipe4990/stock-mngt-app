package br.com.univesp.pi;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @GetMapping("/api/product/name/{productName}")
    public ResponseEntity<List<Product>> getProductsNamesByRegex(@PathVariable(name = "productName") String name, @RequestParam(name = "page",defaultValue = "0") Integer page ) {

        // Get Product from MySQL
        List<Product> products = productService.getProductsNamesByRegex(name, page);

        return ResponseEntity.ok().body(products);
    }

    @CrossOrigin
    @GetMapping("/api/product/manufacturer/{manufacturer}")
    public ResponseEntity<List<Product>> getProductsManufacturersByRegex(@PathVariable(name = "manufacturer") String name, @RequestParam(name = "page",defaultValue = "0") Integer page) {

        // Get Product from MySQL
        List<Product> products = productService.getProductsManufacturersByRegex(name, page);

        return ResponseEntity.ok().body(products);
    }

    @CrossOrigin
    @GetMapping("/api/product/content/{content}")
    public ResponseEntity<List<Product>> getProductsContentsByRegex(@PathVariable(name = "content") String name, @RequestParam(name = "page",defaultValue = "0") Integer page) {

        // Get Product from MySQL
        List<Product> products = productService.getProductsContentsByRegex(name, page);

        return ResponseEntity.ok().body(products);
    }

    @CrossOrigin
    @GetMapping("/api/product/expiration/{days}")
    public ResponseEntity<List<Product>> getProductsSoonToBeExpiredByDays(@PathVariable(name = "days") String name, @RequestParam(name = "page",defaultValue = "0") Integer page) {

        // Get Product from MySQL
        List<Product> products = productService.getProductsSoonToBeExpiredByDays(name, page);

        return ResponseEntity.ok().body(products);
    }

    @CrossOrigin
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getProductsByPagination(@RequestParam(name = "page",defaultValue = "0") Integer page) {

        // Get Product from MySQL
        List<Product> products = productService.getProductsByPagination(page);


        return ResponseEntity.ok().body(products);
    }


}