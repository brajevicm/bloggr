package com.brajevicm.config;

import com.brajevicm.aspect.BlogServiceLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
@Configuration
@EnableAspectJAutoProxy
public class BlogServiceLoggerConfig {

  @Profile("dev")
  @Bean
  public BlogServiceLogger blogServiceLogger() {
    return new BlogServiceLogger();
  }
}
