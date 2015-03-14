package com.palyga.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 10.03.2015.
 */

@Controller
public class CommonController {



    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String getAboutPage(){
        return null;
    }

    @RequestMapping(value = "/404",method = RequestMethod.GET)
    public String getErrorPage(){
        return "404";
    }

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String getAdminPage(){
        return "dashboard";
    }
}
