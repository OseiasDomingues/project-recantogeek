package com.projectdl.recantogeek.dto;

import com.projectdl.recantogeek.models.ProductModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AllProductsDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String imageURL;

    public AllProductsDTO(ProductModel productModel) {
        id = productModel.getId();
        name = productModel.getName();
        price = productModel.getPrice();
        imageURL = productModel.getImageURL();
    }
}
