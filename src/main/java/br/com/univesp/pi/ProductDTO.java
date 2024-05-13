package br.com.univesp.pi;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;

    private String productName;

    private String manufacturer;

    private String content;

    @Column(columnDefinition = "DATE")
    private LocalDate purchaseDate;

    @Column(columnDefinition = "DATE")
    private LocalDate expirationDate;

    private BigDecimal price;

}
