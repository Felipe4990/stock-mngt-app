package br.com.univesp.pi;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate purchaseDate;
    @Column(columnDefinition = "DATE")
    private LocalDate expirationDate;
    private String description;
    private BigDecimal price;

}
