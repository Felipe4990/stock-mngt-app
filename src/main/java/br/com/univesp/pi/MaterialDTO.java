package br.com.univesp.pi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MaterialDTO {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;

}
