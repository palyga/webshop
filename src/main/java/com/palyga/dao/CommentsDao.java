package com.palyga.dao;

import com.palyga.model.Comments;

import java.util.List;

/**
 * Created by Admin on 12.03.2015.
 */



public interface CommentsDao extends AbstractDaoIface<Comments> {

    public List<Comments> getCommentsByProduct(int productId);

}
