package com.palyga.service;

import com.palyga.model.Comments;

import java.util.List;

/**
 * Created by Admin on 12.03.2015.
 */
public interface CommentsManager {

    public void saveComments(Comments comments);

    public void deleteComments(Comments comments);

    public Comments findCommentsById(int id);

    public List<Comments> getAllComments();

    public List<Comments> getCommentsByProduct(int productId);
}
