package com.palyga.web;

import com.palyga.components.impl.JsonMapper;
import com.palyga.components.impl.SessionCounterListener;
import com.palyga.service.ProductsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 12.03.2015.
 */

@Controller
public class DashboardInformController {

    @Autowired
    JsonMapper jsonMapper;

    @Autowired
    ProductsManager productsManager;

    @RequestMapping(value = "/getActiveUsersInf",method = RequestMethod.GET)
    public @ResponseBody int getActiveUserCount(){
        return SessionCounterListener.getActiveUsers();
    }


    //Add to @InitBinder Date Validator
    @RequestMapping(value = "/getOneDaySellingInf",method = RequestMethod.GET)
    public @ResponseBody Model getOneDaySellingInf(@RequestParam("day") int day,Model map){
        //Map<String,Integer> infomap=new HashMap<String, Integer>();
        return null;
    }
}
