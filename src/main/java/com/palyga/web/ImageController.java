package com.palyga.web;


import com.palyga.service.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 10.03.2015.
 */

@Controller
public class ImageController {

    @Autowired
    FileManager fileManager;

    //can throw exception
    @ResponseBody
    @RequestMapping(value = "/picture/{name}", method = RequestMethod.GET)
    public byte[] getImage(@PathVariable("name")String name){
        return fileManager.getFile(name);
    }
}
