package br.com.univesp.pi;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String productName;

    private String manufacturer;

    private String content;

    @Column(columnDefinition = "DATE")
    private LocalDate purchaseDate;

    @Column(columnDefinition = "DATE")
    private LocalDate expirationDate;

    private BigDecimal price;
}
