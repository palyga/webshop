package com.palyga.web;

import com.palyga.components.impl.HtmlEntityEncoder;
import com.palyga.model.Comments;
import com.palyga.service.CommentsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Admin on 12.03.2015.
 */

@Controller
public class CommentsController {

    @Autowired
    CommentsManager commentsManager;



    @RequestMapping(value ="/addComment",method = RequestMethod.POST)
    public String createNewComment(@ModelAttribute("comment") Comments comments){

        //Make comment validator
        String escapedComment = HtmlEntityEncoder.htmlEncode(comments.getComment());
        comments.setComment(escapedComment);
        comments.setDate(new Date());
        commentsManager.saveComments(comments);

        return escapedComment;
    }

    //add to the security template
    //for manager
    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public String deleteComment(){
        return null;
    }





}
