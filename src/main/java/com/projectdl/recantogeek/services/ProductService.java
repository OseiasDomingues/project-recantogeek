package com.projectdl.recantogeek.services;

import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductModel> findAll();
    ProductModel findById(Long id);
    ProductModel save(ProductModel productModel);
    void delete(Long id);
    ProductModel update(Long id, ProductModel productModel);

}
