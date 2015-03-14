package com.palyga.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 11.03.2015.
 */
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue
    @Column(name = "idcomments")
    private int id;
/*
    @
    Users users;*/

    @Column(name = "idproducts")
    private int idproducts;

    @Column(name = "comment")
    private String comment;



    @Column(name = "datecoments")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(int idproducts) {
        this.idproducts = idproducts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
