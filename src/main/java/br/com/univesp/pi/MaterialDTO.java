package br.com.univesp.pi;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MaterialDTO {
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate purchaseDate;
    @Column(columnDefinition = "DATE")
    private LocalDate expirationDate;
    private String description;
    private BigDecimal price;

}
