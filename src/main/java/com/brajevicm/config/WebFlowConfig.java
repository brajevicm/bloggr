package com.brajevicm.config;

import com.brajevicm.flow.RegisterFlowHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

import java.util.Arrays;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    19-Nov-17
 */
//@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

  @Bean
  public FlowHandlerMapping flowHandlerMapping() {
    FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
    handlerMapping.setOrder(-1);
    handlerMapping.setFlowRegistry(flowRegistry());

    return handlerMapping;
  }

  @Bean
  public FlowHandlerAdapter flowHandlerAdapter() {
    FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
    handlerAdapter.setFlowExecutor(flowExecutor());
    handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);

    return handlerAdapter;
  }

  @Bean
  public FlowExecutor flowExecutor() {
    return getFlowExecutorBuilder(flowRegistry())
      .addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
      .build();
  }

  @Bean
  public FlowDefinitionRegistry flowRegistry() {
    return getFlowDefinitionRegistryBuilder(flowBuilderServices())
      .setBasePath("/WEB-INF/templates/flows")
      .addFlowLocationPattern("/**/*-flow.xml").build();
  }

  @Bean
  public FlowBuilderServices flowBuilderServices() {
    return getFlowBuilderServicesBuilder()
      .setViewFactoryCreator(mvcViewFactoryCreator())
      .setValidator(validator())
      .setDevelopmentMode(true)
      .build();
  }

  @Bean
  public MvcViewFactoryCreator mvcViewFactoryCreator() {
    MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
    factoryCreator.setUseSpringBeanBinding(true);

    return factoryCreator;
  }

  @Bean(name = "register")
  public RegisterFlowHandler registerFlowHandler() {
    return new RegisterFlowHandler();
  }

  @Bean
  public LocalValidatorFactoryBean validator() {
    return new LocalValidatorFactoryBean();
  }
}
