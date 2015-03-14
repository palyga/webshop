package com.palyga.dao.impl;


import com.palyga.dao.AbstractDao;
import com.palyga.dao.UsersDao;
import com.palyga.model.Users;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Василь on 24.02.2015.
 */


@Repository
public class UsersDaoImpl extends AbstractDao<Users> implements UsersDao {
    @Override
    public Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public Users findByEmail(String email) {

       //return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.like("email",email)).uniqueResult();
        Query quety=sessionFactory.getCurrentSession().getNamedQuery(Users.GET_BY_EMAIL).setParameter("email",email);
        return (Users)quety.uniqueResult();
    }

    @Override
    public List<Users> getPortionUsers(int startFrom, int resultQuantity) {

        Query query=sessionFactory.getCurrentSession().createQuery("from Users ");
        query.setFirstResult(startFrom);
        query.setMaxResults(resultQuantity);

        return query.list();
    }
}
