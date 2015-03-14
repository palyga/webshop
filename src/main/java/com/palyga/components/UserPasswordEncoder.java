package com.palyga.components;

import com.palyga.model.Users;

/**
 * Created by Admin on 08.03.2015.
 */
public interface UserPasswordEncoder {



    public void encodePassword(Users user);

    //Use for more serious project
    public void encodePasswordWithSalt(Users user);


}
