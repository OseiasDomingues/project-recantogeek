package com.projectdl.recantogeek.controllers;

import com.projectdl.recantogeek.dto.AllProductsDTO;
import com.projectdl.recantogeek.dto.OneProductDTO;
import com.projectdl.recantogeek.mapper.ProductMapper;
import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.services.CategoryService;
import com.projectdl.recantogeek.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

//@RestController
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductMapper productMapper;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("viewProductsList");
        List<ProductModel> productList = productService.findAll();
        List<CategoryModel> categoryList = categoryService.findAll();
        List<AllProductsDTO> allProductsDTOS = productList
                .stream()
                .map(productMapper::allToDTO)
                .collect(Collectors.toList());
        mv.addObject("productsList", allProductsDTOS);
        mv.addObject("categoryList", categoryList);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("viewProduct");
        ProductModel product = productService.findById(id);
        OneProductDTO oneProductDTO = productMapper.oneToDTO(product);
        mv.addObject("product", oneProductDTO);
        return mv;
    }

    @GetMapping("/newproduct")
    public ModelAndView getForm() {
        return new ModelAndView("newproduct");
    }

    @GetMapping("category/{id}")
    public ModelAndView getByCategory(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("pageCategory");
        List<ProductModel> productList = productService.findByCategory(id);
        mv.addObject("productByCategory", productList);
        return mv;
    }

    @PostMapping("/newproduct")
    public String insert(@Valid @ModelAttribute("product") ProductModel productModel, BindingResult result) {
        if (result.hasErrors()) {

            return "redirect:/products";
        }
        productModel.setInstallments(productModel.calcInstallments());
        ProductModel newProduct = productService.save(productModel);
        return "redirect:/products/" + newProduct.getId();
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product") ProductModel productModel) {
        productService.delete(productModel.getId());
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") ProductModel productModel) {
        ProductModel updateProd = productService.update(productModel.getId(), productModel);
        return "redirect:/products/" + updateProd.getId();
    }
}