package com.projectdl.recantogeek.mapper;

import com.projectdl.recantogeek.dto.AllProductsDTO;
import com.projectdl.recantogeek.dto.OneProductDTO;
import com.projectdl.recantogeek.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryModels", target = "category")
    AllProductsDTO allToDTO(ProductModel productModel);

    @Mapping(source = "categoryModels", target = "category")
    OneProductDTO oneToDTO(ProductModel productModel);
}
