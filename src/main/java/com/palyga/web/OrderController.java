package com.palyga.web;


import com.palyga.model.Order;
import com.palyga.service.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class OrderController {

    @Autowired
    OrderManager orderManager;



    //This will be for final project
    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String checkout(){
        return null;
    }

    //REST
    //Do this for dashboard only
    // Admin and Manager
    @RequestMapping(value = "/deleteOrder/{id}",method = RequestMethod.DELETE)
    public  String deleteOrder(@PathVariable("id") int id){
        orderManager.deleteOrder(orderManager.getById(id));
        return "redirect:/main";
    }
    //END REST

}
