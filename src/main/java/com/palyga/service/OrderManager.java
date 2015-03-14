package com.palyga.service;


import com.palyga.model.Order;

import java.util.Map;

/**
 * Created by Василь on 02.03.2015.
 */
public interface OrderManager {

    public Order getById(int id);

    public void saveOrder(Order order);

    public void deleteOrder(Order order);

    public void insertToHelpTable(int orderId, Map<Integer, Integer> map);
}
