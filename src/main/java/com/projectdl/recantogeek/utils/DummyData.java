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

        ProductModel p1 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90));
        ProductModel p2 = new ProductModel(null, "Moleton 02", BigDecimal.valueOf(20.50));
        ProductModel p3 = new ProductModel(null, "Moleton 03", BigDecimal.valueOf(10.50));
        ProductModel p4 = new ProductModel(null, "Moleton 04", BigDecimal.valueOf(12.50));
        ProductModel p5 = new ProductModel(null, "Moleton 05", BigDecimal.valueOf(17.50));
        ProductModel p6 = new ProductModel(null, "Moleton 06", BigDecimal.valueOf(20.50));
        ProductModel p7 = new ProductModel(null, "Moleton 07", BigDecimal.valueOf(10.50));
        ProductModel p8 = new ProductModel(null, "Moleton 08", BigDecimal.valueOf(12.50));
        ProductModel p9 = new ProductModel(null, "Moleton 09", BigDecimal.valueOf(17.50));
        ProductModel p10 = new ProductModel(null, "Moleton 10", BigDecimal.valueOf(20.50));
        ProductModel p11 = new ProductModel(null, "Moleton 11", BigDecimal.valueOf(10.50));
        ProductModel p12 = new ProductModel(null, "Moleton 12", BigDecimal.valueOf(12.50));

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12));
    }
}
