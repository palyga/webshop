package com.palyga.components.impl;

import org.springframework.stereotype.Component;

/**
 * Created by Admin on 10.03.2015.
 */

@Component
public class ImageEncoderPath {

    public String getPath(String productName){
        return productName.replaceAll(" ","").toLowerCase();
    }


    public String getImageName(String productName){
        return productName.replaceAll(" ","").toLowerCase();
    }
}
