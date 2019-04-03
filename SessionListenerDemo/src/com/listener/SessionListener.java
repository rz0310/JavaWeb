package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class SessionListener implements HttpSessionListener{

    // Public constructor is required by servlet spec
    public SessionListener() {
        System.out.println("监听器的构造方法");
    }
    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session被创建");
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session被销毁");
        /* Session is destroyed. */
    }
}
