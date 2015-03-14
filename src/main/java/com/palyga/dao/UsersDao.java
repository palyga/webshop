package com.palyga.dao;



import com.palyga.model.Users;

import java.util.List;

/**
 * Created by Василь on 24.02.2015.
 */
public interface UsersDao extends AbstractDaoIface<Users> {

    public Users findByEmail(String email);

    public List<Users> getPortionUsers(int startFrom, int resultQuantity);

}
