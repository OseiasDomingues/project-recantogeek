package com.projectdl.recantogeek.services;

import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryModel> findAll();
    CategoryModel findById(Long id);

}
