package com.projectdl.recantogeek.services.impl;

import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.CategoryRepository;
import com.projectdl.recantogeek.repositories.ProductRepository;
import com.projectdl.recantogeek.services.CategoryService;
import com.projectdl.recantogeek.services.ProductService;
import com.projectdl.recantogeek.services.exceptions.PageNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryModel> findAll() {
        //todo productRepository.findAll(Sort.sort(Sort.Direction.ASC, "name"));
        return categoryRepository.findAll();
    }
    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new PageNotFound("Page not found"));
    }

}
