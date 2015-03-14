package com.palyga.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Василь on 24.02.2015.
 */
public abstract class AbstractDao<E> implements AbstractDaoIface<E> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public List<E> getAll() {
        System.out.println("From "+ getEntityClass().getCanonicalName());
        return sessionFactory.getCurrentSession().createQuery("From "+ getEntityClass().getCanonicalName()).list();
    }

    @Override
    public E findById(int id) {
        return (E)sessionFactory.getCurrentSession().get(getEntityClass(),id);
    }

    @Override
    public void save(E... entities) {
        for(E entity: entities){
            sessionFactory.getCurrentSession().save(entity);
        }
    }

    @Override
    public void delete(E... entities) {
        for (E entity : entities){
            sessionFactory.getCurrentSession().delete(entity);
        }
    }


    @Override
    public void update(E... entities) {
        for(E entity : entities){
            sessionFactory.getCurrentSession().update(entity);
        }

    }

    public  abstract Class<E> getEntityClass();
}
