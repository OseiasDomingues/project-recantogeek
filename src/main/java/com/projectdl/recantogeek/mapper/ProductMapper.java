package com.projectdl.recantogeek.mapper;

import com.projectdl.recantogeek.dto.AllProductsDTO;
import com.projectdl.recantogeek.dto.OneProductDTO;
import com.projectdl.recantogeek.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    AllProductsDTO allToDTO(ProductModel productModel);

    OneProductDTO oneToDTO(ProductModel productModel);
}
