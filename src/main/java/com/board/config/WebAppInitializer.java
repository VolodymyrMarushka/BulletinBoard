package com.board.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebAppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
                dispatcherServlet);

        myCustomDispatcherServlet.setLoadOnStartup(1);
        myCustomDispatcherServlet.addMapping("/");
    }
}
