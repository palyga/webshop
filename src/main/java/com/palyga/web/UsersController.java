package com.palyga.web;


import com.palyga.model.Users;
import com.palyga.service.FileManager;
import com.palyga.service.ProductsManager;
import com.palyga.service.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UsersController {


    @Autowired
    UsersManager usersManager;

    @Autowired
    ProductsManager productsManager;

    @Autowired
    FileManager fileManager;



    //Only for dashboard
    @RequestMapping(value = "users/{from}/{limit}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Users> getUsersByLimit(
            @PathVariable("from") int from, @PathVariable("limit") int limit) {
        return usersManager.getAll();
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute(value = "users") Users user, BindingResult result) {
        usersManager.save(user);
        return "redirect:/";
    }


}
