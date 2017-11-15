package com.brajevicm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
@Configuration
@ComponentScan(basePackages = {"com.brajevicm"},
  excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
  }
)
public class RootConfig {
}
