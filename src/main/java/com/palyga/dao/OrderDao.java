package com.palyga.dao;


import com.palyga.model.Order;

/**
 * Created by Василь on 02.03.2015.
 */
public interface OrderDao extends AbstractDaoIface<Order> {

    public void putToHelpTable(int orderId, int productId, int quality);

}
