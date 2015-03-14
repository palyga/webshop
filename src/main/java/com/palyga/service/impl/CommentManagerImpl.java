package com.palyga.service.impl;

import com.palyga.dao.CommentsDao;
import com.palyga.model.Comments;
import com.palyga.service.CommentsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 12.03.2015.
 */

@Service
public class CommentManagerImpl implements CommentsManager {

    @Autowired
    CommentsDao commentsDao;

    @Override
    @Transactional
    public void saveComments(Comments comments) {
        commentsDao.save(comments);
    }


    @Override
    @Transactional
    public void deleteComments(Comments comments) {
        commentsDao.delete(comments);
    }

    @Override
    @Transactional
    public Comments findCommentsById(int id) {
        return commentsDao.findById(id);
    }

    @Override
    @Transactional
    public List<Comments> getCommentsByProduct(int productId) {
        return commentsDao.getCommentsByProduct(productId);
    }

    @Override
    @Transactional
    public List<Comments> getAllComments() {
        return commentsDao.getAll();
    }
}
