package com.projectdl.recantogeek.services.impl;

import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.ProductRepository;
import com.projectdl.recantogeek.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductModel> findAll() {
        //todo productRepository.findAll(Sort.sort(Sort.Direction.ASC, "name"));
        return productRepository.findAll();
    }

    @Override
    public ProductModel findById(Long id) {
        return productRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        return null;
    }
}
