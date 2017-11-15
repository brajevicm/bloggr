package com.brajevicm.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Locale;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.brajevicm.controller")
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
  private ApplicationContext applicationContext;

  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    interceptor.setParamName("language");
    registry.addInterceptor(interceptor);
  }

  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(Locale.ENGLISH);

    return localeResolver;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
      new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/resources/messages");
    messageSource.setDefaultEncoding("ISO-8859-9");
    messageSource.setCacheSeconds(10);

    return messageSource;
  }

  @Bean
  public ViewResolver viewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setCharacterEncoding("ISO-8859-9");

    return viewResolver;
  }

  @Bean
  public TemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setEnableSpringELCompiler(true);
    templateEngine.setTemplateResolver(templateResolver());

    return templateEngine;
  }

  private ITemplateResolver templateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setApplicationContext(applicationContext);
    templateResolver.setPrefix("/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);

    return templateResolver;
  }
}
