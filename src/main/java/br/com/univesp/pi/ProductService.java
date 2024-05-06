package br.com.univesp.pi;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(Long id);

    List<Product> getProductByRegex(String regex);

}
