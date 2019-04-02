package com.example.vaadintest;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
    asyncSupported=false,
    urlPatterns={"/*","/VAADIN/*"},
    initParams={
        @WebInitParam(name="ui", value="com.example.vaadintest.VaadinTestUI")
    })
public class VaadinTestServlet extends com.vaadin.server.VaadinServlet { }
