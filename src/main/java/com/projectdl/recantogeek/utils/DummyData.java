package com.projectdl.recantogeek.utils;

import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DummyData {

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void mock(){

        ProductModel p1 = new ProductModel(null, "Moleton 01", BigDecimal.valueOf(17.50));
        ProductModel p2 = new ProductModel(null, "Moleton 02", BigDecimal.valueOf(20.50));
        ProductModel p3 = new ProductModel(null, "Moleton 03", BigDecimal.valueOf(10.50));
        ProductModel p4 = new ProductModel(null, "Moleton 04", BigDecimal.valueOf(12.50));

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
    }
}
