package com.gestion.spring.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.gestion.spring.AppConfig;
import com.gestion.spring.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 * this class will load all servlet
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]
        {
            AppConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[]
        {
            WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]
        {
            "/"
        };
    }

}
