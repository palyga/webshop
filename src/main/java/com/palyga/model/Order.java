package com.palyga.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by Василь on 01.03.2015.
 */


@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idorder")
    private int id;

    //@JsonIgnore
    @ElementCollection
    @CollectionTable(name="orderhelp",joinColumns =@JoinColumn(name = "idorder"))
    @Column(name = "quantity")
    @MapKeyJoinColumn(name = "idproducts")
    //@OneToMany
    @JoinTable(name = "orderhelp")
    @MapKeyColumn(name = "idproducts")
    private Map<Integer,Integer> productsQuantityMap;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iduser")
    private Users user;

    @Column(name = "soldtime")
    private Date soldDate;

    @Column(name = "destination")
    private String destination;

    @Column(name = "status")
    private String orderStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Integer, Integer> getProductsQuantityMap() {
        return productsQuantityMap;
    }

    public void setProductsQuantityMap(Map<Integer, Integer> productsQuantityMap) {
        this.productsQuantityMap = productsQuantityMap;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", soldDate=" + soldDate +
                ", destination='" + destination + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
