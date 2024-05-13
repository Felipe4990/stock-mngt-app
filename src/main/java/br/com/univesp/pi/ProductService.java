package br.com.univesp.pi;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product material);

    Product getProductById(Long id);

    List<Product> getProductsNamesByRegex(String regex);

    void deleteProductById(Long id);
}
