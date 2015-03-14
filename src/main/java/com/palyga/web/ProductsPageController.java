package com.palyga.web;

import com.palyga.service.CommentsManager;
import com.palyga.service.ProductsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 11.03.2015.
 */

@Controller
public class ProductsPageController {

    @Autowired
    ProductsManager productsManager;

    @Autowired
    CommentsManager commentsManager;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getHomePage(Model map){
        map.addAttribute("productsList",productsManager.getAll());
        return "home";
    }

    //зробити сторінку без слайдера
    @RequestMapping(value = "/tablet/",method = RequestMethod.GET)
    public String getTabletPage(Model map){
        map.addAttribute("productsList",productsManager.getByCategory("tablet"));
        return "category";
    }

    @RequestMapping(value = "/mobile/",method = RequestMethod.GET)
    public String getMobilePage(Model map){
        map.addAttribute("productsList",productsManager.getByCategory("mobile"));
        return "category";
    }

    @RequestMapping(value = "/notebook/",method = RequestMethod.GET)
    public String getNotebookPage(Model map){
        map.addAttribute("productsList",productsManager.getByCategory("notebook"));
        return "category";
    }

    @RequestMapping(value = "/mobile/{id}",method = RequestMethod.GET)
    public String getNotebookProductPage(@PathVariable("id")int id,Model map){
        map.addAttribute("product",productsManager.findProductById(id));
        map.addAttribute("commentList",commentsManager.getCommentsByProduct(id));
        return "product";
    }

    @RequestMapping(value = "/notebook/{id}",method = RequestMethod.GET)
    public String getMobileProductPage(@PathVariable("id")int id,Model map){
        map.addAttribute("product",productsManager.findProductById(id));
        map.addAttribute("commentList",commentsManager.getCommentsByProduct(id));
        return "product";
    }

    @RequestMapping(value = "/tablet/{id}",method = RequestMethod.GET)
    public String getTabletProductPage(@PathVariable("id")int id,Model map){
        map.addAttribute("product",productsManager.findProductById(id));
        map.addAttribute("commentList",commentsManager.getCommentsByProduct(id));
        return "product";
    }
















}
