package br.com.univesp.pi;

import jakarta.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${app.pagination.max-hits-per-page}")
    private int maxHitsPerPage;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException(String.valueOf(id));
        }
    }

    @Override
    public List<Product> getProductsNamesByRegex(String regex, Integer page) {
        Pageable pageable = PageRequest.of(page, maxHitsPerPage);

        return productRepository.getProductsNamesByRegex(regex, pageable);
    }
    @Override
    public List<Product> getProductsManufacturersByRegex(String regex, Integer page) {
        Pageable pageable = PageRequest.of(page, maxHitsPerPage);

        return productRepository.getProductsManufacturersByRegex(regex, pageable);
    }
    @Override
    public List<Product> getProductsContentsByRegex(String regex, Integer page) {
        Pageable pageable = PageRequest.of(page, maxHitsPerPage);

        return productRepository.getProductsContentsByRegex(regex, pageable);
    }
    @Override
    public List<Product> getProductsSoonToBeExpiredByDays(String days, Integer page) {
        Pageable pageable = PageRequest.of(page, maxHitsPerPage);

        return productRepository.getProductsSoonToBeExpiredByDays(days, pageable);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByPagination(Integer page){
        Pageable pageable = PageRequest.of(page, maxHitsPerPage);
        return productRepository.getProductsByPagination(pageable);
    }

    //@Override
    //public List<Product> getProductsByPagination(Pageable pageable) {
    //    Page<Product> pageUser = productRepository.findAll(pageable);
    //    return pageUser.getContent();
    //}

}
