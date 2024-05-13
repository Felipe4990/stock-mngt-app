package br.com.univesp.pi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE productName LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsNamesByRegex(@Param("regex") String regex);

    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE manufacturer LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsManufacturersByRegex(@Param("regex") String regex);

    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE content LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsContentsByRegex(@Param("regex") String regex);

    //@Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE purchaseDate LIKE CONCAT('%',:regex,'%')")
    //public <T> ArrayList<T> getProductsPurchaseDatesByRegex(@Param("regex") String regex);
}
