package com.brajevicm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{RootConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    servletContext.setInitParameter("spring.profiles.active", "dev");
  }
}
