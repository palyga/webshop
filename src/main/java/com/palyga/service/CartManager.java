package com.palyga.service;

import com.palyga.components.impl.Cart;
import com.palyga.model.Products;

import java.util.Map;
import java.util.Set;

/**
 * Created by Admin on 11.03.2015.
 */
public interface CartManager {

    public int getTotalPrise(Cart cart);

    public Map<Products,Integer> getProductsFromCart(Cart cart);

    public void plusProducts(Cart cart, int id);

    public void minusProducts(Cart cart, int id);

    public int getProductAmount(Cart cart, int id);

    public int getProductsPrice(Cart cart, int id);

    public Set<Integer> getCartProductsList(Cart cart);
}
