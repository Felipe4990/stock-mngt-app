package br.com.univesp.pi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE productName LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsNamesByRegex(@Param("regex") String regex, Pageable pageable);

    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE manufacturer LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsManufacturersByRegex(@Param("regex") String regex, Pageable pageable);

    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE content LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getProductsContentsByRegex(@Param("regex") String regex, Pageable pageable);

    //@Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product WHERE purchaseDate LIKE CONCAT('%',:regex,'%')")
    @Query(value = "SELECT id,product_name,manufacturer,content,price,expiration_date,purchase_date FROM product WHERE expiration_date < now() + INTERVAL ?1 day", nativeQuery = true)
    public <T> ArrayList<T> getProductsSoonToBeExpiredByDays(@Param("regex") String days, Pageable pageable);

    @Query("SELECT id,productName,manufacturer,content,price,expirationDate,purchaseDate FROM Product")
    public <T> ArrayList<T> getProductsByPagination(Pageable pageable);

}
