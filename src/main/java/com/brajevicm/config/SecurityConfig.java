package com.brajevicm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    @formatter:off
    http
      .formLogin().loginPage("/login").failureUrl("/login?error")
        .usernameParameter("username").passwordParameter("password")
    .and()
      .rememberMe().key("bloggrKey")
    .and()
      .logout().logoutSuccessUrl("/login?logout")
    .and()
      .httpBasic().realmName("Bloggr")
    .and()
      .csrf()
    .and()
    .authorizeRequests()
      .antMatchers("/blogger/me").authenticated()
      .antMatchers("/blog/new").authenticated()
      .anyRequest().permitAll()
      .and()
        .requiresChannel().antMatchers("blog/new").requiresSecure()
//      .and()
//        .requiresChannel().antMatchers("register").requiresSecure()
        .antMatchers("/").requiresInsecure();
    //    @formatter:on
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .jdbcAuthentication().dataSource(dataSource)
      .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
      .authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username = ?");
  }
}
