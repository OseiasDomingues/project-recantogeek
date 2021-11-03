package com.projectdl.recantogeek.services.impl;

import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.ProductRepository;
import com.projectdl.recantogeek.services.ProductService;
import com.projectdl.recantogeek.services.exceptions.PageNotFound;
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
        return productRepository.findById(id).orElseThrow(() -> new PageNotFound("Page not found"));
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductModel update(Long id, ProductModel productModel) {
        ProductModel oldProd = productRepository.getById(id);
        ProductModel updateProd = updateData(oldProd, productModel);
        return productRepository.save(updateProd);
    }

    private ProductModel updateData(ProductModel oldProd, ProductModel productModel) {
        oldProd.setName(productModel.getName());
        oldProd.setPrice(productModel.getPrice());
        return oldProd;
    }
}
