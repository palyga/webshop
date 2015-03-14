package com.palyga.components.impl;

import com.palyga.components.UserPasswordEncoder;
import com.palyga.model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 08.03.2015.
 */

@Component
public class UserPasswordEncoderImpl implements UserPasswordEncoder {

    @Override
    public void encodePassword(Users user) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String bcyptPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(bcyptPassword);
    }

    //Use for more serious project
    @Override
    public void encodePasswordWithSalt(Users user) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String bcyptPassword=passwordEncoder.encode(user.getPassword()+user.getEmail());
        user.setPassword(bcyptPassword);
    }
}
