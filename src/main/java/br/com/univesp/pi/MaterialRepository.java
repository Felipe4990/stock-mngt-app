package br.com.univesp.pi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    @Query("SELECT id,name,description,price FROM Material WHERE name LIKE CONCAT('%',:regex,'%')")
    public <T> ArrayList<T> getMaterialByRegex(@Param("regex") String regex);

}
