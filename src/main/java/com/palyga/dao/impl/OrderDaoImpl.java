package com.palyga.dao.impl;


import com.palyga.dao.AbstractDao;
import com.palyga.dao.OrderDao;
import com.palyga.model.Order;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by Василь on 02.03.2015.
 */

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }

    @Override
    public void putToHelpTable(int orderId, int productId, int quality) {
        String sqlQuery="INSERT INTO `webshop`.`orderhelp`" +
                " (`idorder`, `idproducts`, `quantity`)" +
                " VALUES (:orderId, :productId, :quality);";
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);

        query.setParameter("orderId",orderId);
        query.setParameter("productId",productId);
        query.setParameter("quality",quality);
        query.executeUpdate();

    }
}
