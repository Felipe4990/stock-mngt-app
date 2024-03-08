package br.com.univesp.pi.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String name;
    private String description;
    private Money price;
}
