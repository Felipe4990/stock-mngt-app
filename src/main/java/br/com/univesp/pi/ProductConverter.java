package br.com.univesp.pi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductConverter implements Converter<Product, ProductDTO> {


    @Autowired
    @Qualifier("mvcConversionService")
    ConversionService conversionService;

    @Override
    public ProductDTO convert(Product group) {

        String foo = "";

        //List<ProductDTO> studentDtoList = group.stream().map(a -> conversionService.convert(a, ProductDTO.class)).collect(Collectors.toList());
        //ProductDTO groupDto = new ProductDTO(group.getId(), group.getName(), studentDtoList);

        return null;
    }

}
