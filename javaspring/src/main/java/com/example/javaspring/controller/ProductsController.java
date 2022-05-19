package com.example.javaspring.controller;

import com.example.javaspring.dto.ProductsDto;
import com.example.javaspring.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @PreAuthorize("hasAuthority('list_product')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ProductsDto> listProducts(){
        List<ProductsDto> productsDtoList = productsService.listProduct();
        return productsDtoList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductsDto getOne(@PathVariable long id){
        return productsService.getOne(id);
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void productsPost(@RequestBody ProductsDto p){
      productsService.postProduct(p);

    }

    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public void productsPut(@RequestBody ProductsDto p, @PathVariable long id){
       productsService.putProduct(p,id);

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void productsDelete(@PathVariable long id){
        productsService.deleleProducts(id);
    }

}
