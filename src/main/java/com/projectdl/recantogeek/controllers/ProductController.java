package com.projectdl.recantogeek.controllers;

import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
//@RestController
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("viewProductsList");
        List<ProductModel> productList = productService.findAll();
        mv.addObject("productsList", productList);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("viewProduct");
        ProductModel product = productService.findById(id);
        mv.addObject("product", product);
        return mv;
    }
    @PostMapping
    public String insert(@Valid @ModelAttribute("product") ProductModel productModel, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/products";
        }
        productService.save(productModel);
        return "redirect:/products";
    }
}