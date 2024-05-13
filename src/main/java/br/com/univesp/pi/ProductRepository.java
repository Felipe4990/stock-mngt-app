package br.com.univesp.pi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT id,productName,manufacturer,description,price,expirationDate,purchaseDate FROM Product WHERE productName LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsNamesByRegex(@Param("regex") String regex);

}
