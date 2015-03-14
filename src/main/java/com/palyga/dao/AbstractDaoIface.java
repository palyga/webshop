package com.palyga.dao;

import java.util.List;

/**
 * Created by Василь on 24.02.2015.
 */
public interface AbstractDaoIface<E> {

    public E findById(int id);

    public List<E> getAll();

    public void save(E... entity);

    public void delete(E... entity);

    public void update(E... entity);



}
