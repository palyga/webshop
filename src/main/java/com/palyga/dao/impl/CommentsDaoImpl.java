package com.palyga.dao.impl;

import com.palyga.dao.AbstractDao;
import com.palyga.dao.CommentsDao;
import com.palyga.model.Comments;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 12.03.2015.
 */
@Repository
public class CommentsDaoImpl extends AbstractDao<Comments> implements CommentsDao {

    @Override
    public Class<Comments> getEntityClass() {
        return Comments.class;
    }

    @Override
    public List<Comments> getCommentsByProduct(int productId) {

        String hql="FROM Comments c WHERE c.idproducts=:productId ORDER BY  c.date DESC";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("productId",productId);
        return query.list();
    }
}
