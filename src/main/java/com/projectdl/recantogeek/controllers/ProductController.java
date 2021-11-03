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
    @GetMapping("/newproduct")
    public ModelAndView getForm() {
        return new ModelAndView("newproduct");
    }

    @PostMapping("/newproduct")
    public String insert(@Valid @ModelAttribute("product") ProductModel productModel, BindingResult result){
        if(result.hasErrors()){

            return "redirect:/products";
        }
        ProductModel newProduct = productService.save(productModel);
        return "redirect:/products/" + newProduct.getId();
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("product")ProductModel productModel){
        productService.delete(productModel.getId());
        return "redirect:/products";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product")ProductModel productModel){
        ProductModel updateProd = productService.update(productModel.getId(),productModel);
        return "redirect:/products/" + updateProd.getId();
    }
}