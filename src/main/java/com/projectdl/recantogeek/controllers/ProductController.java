package com.projectdl.recantogeek.controllers;

import com.projectdl.recantogeek.dto.AllProductsDTO;
import com.projectdl.recantogeek.dto.OneProductDTO;
import com.projectdl.recantogeek.mapper.ProductMapper;
import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.services.CategoryService;
import com.projectdl.recantogeek.services.ProductService;
import com.projectdl.recantogeek.services.exceptions.PageNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        List<AllProductsDTO> allProductsDTOS = productList
                .stream()
                .map(productMapper::allToDTO)
                .collect(Collectors.toList());
        mv.addObject("productsList", allProductsDTOS);

        List<CategoryModel> categoryList = categoryService.findAll();
        mv.addObject("categoryList", categoryList);

        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {

        ModelAndView mv = new ModelAndView("viewProduct");

        ProductModel product = productService.findById(id);
        OneProductDTO oneProductDTO = productMapper.oneToDTO(product);
        mv.addObject("product", oneProductDTO);

        List<CategoryModel> categoryList = categoryService.findAll();
        mv.addObject("categoryList", categoryList);
        return mv;
    }

    @GetMapping("/newproduct")
    public ModelAndView getForm() {

        ModelAndView mv = new ModelAndView("newproduct");

        List<CategoryModel> categoryList = categoryService.findAll();
        mv.addObject("categoryList", categoryList);

        return mv;
    }

    @GetMapping("category/{id}")
    public ModelAndView getByCategory(@PathVariable Long id) {

            ModelAndView mv = new ModelAndView("pageCategory");

            List<ProductModel> productList = productService.findByCategory(id);
            if(productList.isEmpty()){
                throw new PageNotFound("Página não encontrada");
            }
            mv.addObject("productByCategory", productList);

            List<CategoryModel> categoryList = categoryService.findAll();
            mv.addObject("categoryList", categoryList);

            return mv;


    }

    @PostMapping("/newproduct")
    public String insert(@Valid @ModelAttribute("product") ProductModel productModel) {

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