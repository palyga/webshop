package com.palyga.web;


import com.palyga.model.Products;
import com.palyga.service.ProductsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Василь on 28.02.2015.
 */


@Controller
public class ProductsController {

    @Autowired
    ProductsManager productsManager;


    //REST
    //Only for
    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") int id){
        productsManager.delete(productsManager.findProductById(id));
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void putProduct(@PathVariable("id") int id){
        productsManager.update(productsManager.findProductById(id));
    }

    @RequestMapping(value = "/product/{from}/{limit}",method = RequestMethod.GET)
    public @ResponseBody
    List<Products> getPortionOfProducts(@PathVariable int from,@PathVariable int limit){
        return productsManager.getPortionProducts(from,limit);
    }
    //END REST


    @RequestMapping(value = "/getProductsByLimit/{from}/{limit}/",method = RequestMethod.GET)
    public @ResponseBody
    List<Products> getProductsByLimit(@PathVariable int from,@PathVariable int limit){
        return productsManager.getPortionProducts(from,limit);
    }

    @RequestMapping(value = "/getProductsByLimit/{category}/{from}/{limit}",method = RequestMethod.GET)
    public @ResponseBody
    List<Products> getPortionProductsByCategory
            (@PathVariable("category") String category,
             @PathVariable("from") int from,
             @PathVariable("limit") int limit){
        return productsManager.getPortionProductsByCategory(category,from,limit);
    }




}
