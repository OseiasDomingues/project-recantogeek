package com.projectdl.recantogeek.services.impl;

import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.CategoryRepository;
import com.projectdl.recantogeek.repositories.ProductRepository;
import com.projectdl.recantogeek.services.ProductService;
import com.projectdl.recantogeek.services.exceptions.PageNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public List<ProductModel> findByCategory(Long id) {
        List<ProductModel> list = productRepository.findAll();

        return list
                .stream()
                .filter(x -> x.getCategory().getId().equals(id))
                .collect(Collectors.toList());
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
        if (!productModel.getName().isEmpty()){
            oldProd.setName(productModel.getName());
        }
        if (productModel.getPrice() != null){
            oldProd.setPrice(productModel.getPrice());
            oldProd.setInstallments(productModel.calcInstallments());
        }
        if (!productModel.getImageURL().isEmpty()){
            oldProd.setImageURL(productModel.getImageURL());
        }
        if (!productModel.getDescription().isEmpty()){
            oldProd.setDescription(productModel.getDescription());
        }
        if (productModel.getCategory() != null){
            oldProd.setCategory(productModel.getCategory());
        }
        return oldProd;
    }
}
