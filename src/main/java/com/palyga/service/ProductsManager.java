package com.palyga.service;


import com.palyga.model.Products;

import java.util.List;

/**
 * Created by Василь on 25.02.2015.
 */
public interface ProductsManager {

    public List<Products> getAll();

    public Products findProductById(int id);

    public void save(Products... products);

    public void delete(Products... products);

    public void update(Products... products);

    public Products findByName(String name);

    public List<Products> getPortionProductsByCategory(String category, int startFrom, int resultQuantity);
    ///Rename later
    public List<Products> getPortionProducts(int startFrom, int resultQuantity);

    public int getProductPrice(int productId);

    public List<Products> getByCategory(String category);
}
