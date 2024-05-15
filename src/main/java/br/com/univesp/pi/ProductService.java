package br.com.univesp.pi;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product material);

    Product getProductById(Long id);

    List<Product> getProductsNamesByRegex(String regex, Integer page);

    List<Product> getProductsManufacturersByRegex(String regex, Integer page);

    List<Product> getProductsContentsByRegex(String regex, Integer page);

    List<Product> getProductsSoonToBeExpiredByDays(String regex, Integer page);

    void deleteProductById(Long id);

    List<Product> getProductsByPagination(Integer page);

}
