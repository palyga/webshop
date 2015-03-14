package com.palyga.components.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Василь on 27.02.2015.
 */



@Component("cart")
@Scope("session")
public class Cart {

    private static final int CART_MAX_SIZE=60;

    private int currentProductsSize=0;

    private Map<Integer,Integer> productsCart;

    public Cart() {
        this.productsCart = new HashMap<Integer, Integer>();
    }

    public int getCurrentProductsSize() {
        return currentProductsSize;
    }

    public void setCurrentProductsSize(int currentProductsSize) {
        this.currentProductsSize = currentProductsSize;
    }

    public void minusFromCurrentProductsSize(int productsNumber) {
        this.currentProductsSize-= productsNumber;
    }

    public void plusFromCurrentProductsSize(int productsNumber) {
        this.currentProductsSize+= productsNumber;
    }

    public Map<Integer,Integer> getProductsCart() {
        return productsCart;
    }

    public void addProduct(Integer productId,int quantity){
       if (getCurrentProductsSize()<CART_MAX_SIZE){
           plusFromCurrentProductsSize(1);
            productsCart.put(productId,quantity);
       }
    }

    public void removeProduct(Integer productId){
        if(getCurrentProductsSize()>0){
            minusFromCurrentProductsSize(1);
            productsCart.remove(productId);
        }

    }

    public void clear(){
        productsCart.clear();
        setCurrentProductsSize(0);
    }


}
