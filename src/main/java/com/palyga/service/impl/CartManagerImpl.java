package com.palyga.service.impl;

import com.palyga.components.impl.Cart;
import com.palyga.model.Products;
import com.palyga.service.CartManager;
import com.palyga.service.ProductsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Admin on 11.03.2015.
 */


@Service
public class CartManagerImpl implements CartManager {

    @Autowired
    ProductsManager productsManager;

    @Override
    public int getTotalPrise(Cart cart) {
        int totalPrize=0;
        Map<Integer,Integer> bucket=cart.getProductsCart();
        for(Map.Entry entry: bucket.entrySet()){
            totalPrize+=productsManager.getProductPrice((Integer)entry.getKey())*(Integer)entry.getValue();
        }
        return totalPrize;
    }

    @Override
    public Set<Integer> getCartProductsList(Cart cart) {
        return cart.getProductsCart().keySet();
    }

    @Override
    public Map<Products,Integer> getProductsFromCart(Cart cart){
        Map<Products,Integer> map=new HashMap<Products, Integer>();

        for(Map.Entry entry : cart.getProductsCart().entrySet() ){
            Products products=productsManager.findProductById((Integer)entry.getKey());
            map.put(products,(Integer)entry.getValue());
        }
        return map;
    }

    @Override
    public int getProductsPrice(Cart cart, int id) {
        int price=productsManager.getProductPrice(id);
        int amount=cart.getProductsCart().get(id);
        return price*amount;
    }

    @Override
    public int getProductAmount(Cart cart, int id) {
        return cart.getProductsCart().get(id);
    }

    //It's using while i haven't  js cart
    @Override
    public void plusProducts(Cart cart, int id) {
        int amount=cart.getProductsCart().get(id);
        cart.getProductsCart().put(id,amount+1);
    }

    @Override
    public void minusProducts(Cart cart, int id) {
        int amount=cart.getProductsCart().get(id);
        cart.getProductsCart().put(id,amount-1);
    }





}
