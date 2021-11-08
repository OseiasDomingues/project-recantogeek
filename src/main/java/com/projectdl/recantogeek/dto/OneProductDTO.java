package com.projectdl.recantogeek.dto;

import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OneProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Double installments;
    private String imageURL;
    private CategoryModel category;

    public OneProductDTO(ProductModel productModel) {
        id = productModel.getId();
        name = productModel.getName();
        price = productModel.getPrice();
        imageURL = productModel.getImageURL();
        description = productModel.getDescription();
        installments = productModel.getInstallments();
        category = productModel.getCategory();
    }
}
