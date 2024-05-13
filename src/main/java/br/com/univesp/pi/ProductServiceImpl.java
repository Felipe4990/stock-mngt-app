package br.com.univesp.pi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

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
    public List<Product> getProductsNamesByRegex(String regex) {


        return productRepository.getProductsNamesByRegex(regex);
    }

    @Override
    public void deleteProductById(Long id) {

        productRepository.deleteById(id);
    }


}
