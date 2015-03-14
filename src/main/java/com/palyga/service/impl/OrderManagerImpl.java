package com.palyga.service.impl;


import com.palyga.dao.OrderDao;
import com.palyga.model.Order;
import com.palyga.service.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Василь on 02.03.2015.
 */

@Service
public class OrderManagerImpl implements OrderManager {

    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    public Order getById(int id) {
        System.out.println("In order manager");
        return orderDao.findById(id);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        try {
            orderDao.delete(order);
        }catch (RuntimeException e){
            throw e;
        }

    }

    @Override
    public void insertToHelpTable(int orderId, Map<Integer,Integer> map) {
        for (Map.Entry entry:map.entrySet()){
            orderDao.putToHelpTable(orderId, (Integer)entry.getKey(),(Integer)entry.getValue());
        }

    }
}
