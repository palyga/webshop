package com.palyga.service;



import com.palyga.model.Users;

import java.util.List;

/**
 * Created by Василь on 24.02.2015.
 */
public interface UsersManager {

    public Users findUserById(int id);

    public Users findByEmail(String email);

    public List<Users> getAll();

    public void save(Users... users);

    public void delete(Users... users);

    public void update(Users... users);

    public boolean createNewUser(Users users);

}
