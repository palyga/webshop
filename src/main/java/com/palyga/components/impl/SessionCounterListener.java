package com.palyga.components.impl;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Admin on 12.03.2015.
 */
public class SessionCounterListener implements HttpSessionListener {

    private static int activeUsers;

    public static int getActiveUsers(){
        return activeUsers;
    }


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        activeUsers++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        activeUsers--;
    }
}
