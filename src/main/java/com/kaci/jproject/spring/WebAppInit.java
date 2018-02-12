package com.kaci.jproject.spring;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context.
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        //context.register(getConfigs());
        //context.setConfigLocation("com.kaci.jproject.spring");

        // Manage the lifecycle of the root application context.
        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        context.registerShutdownHook();
    }

    Class[] getConfigs() {
        return new Class[]{SpringConfig.class, SwaggerConfig.class};
    }
}
