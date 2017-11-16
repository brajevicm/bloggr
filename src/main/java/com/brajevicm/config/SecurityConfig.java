package com.brajevicm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
      .and()
      .rememberMe().key("bloggrKey")
      .and()
      .logout()
      .and()
      .httpBasic().realmName("Bloggr")
      .and()
      .authorizeRequests()
      .antMatchers("blogger/me").authenticated()
      .antMatchers(HttpMethod.POST, "blog/new").authenticated()
      .anyRequest().permitAll()
      .and()
      .requiresChannel().antMatchers("blog/new").requiresSecure()
      .regexMatchers("/").requiresInsecure();

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("user").password("user").roles("USER")
      .and()
      .withUser("admin").password("admin").roles("ADMIN");
  }
}
