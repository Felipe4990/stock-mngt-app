package br.com.univesp.pi;

import br.com.univesp.pi.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //@Query("SELECT name FROM Product WHERE name LIKE '%?1%'")
    @Query("SELECT id,name,description,price FROM Product WHERE name LIKE '%bolo%'")
    public <T> ArrayList<T> getProductByRegex(String regex);

}
