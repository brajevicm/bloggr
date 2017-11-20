package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Repository("bloggerRepository")
public class BloggerRepositoryImpl implements BloggerRepository {
  private JdbcOperations jdbc;

  @Inject
  public BloggerRepositoryImpl(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Blogger create(Blogger blogger) {
    jdbc.update(
      "INSERT INTO users (username, password)" +
        " VALUES (?, ?)",
      blogger.getUsername(),
      blogger.getPassword()
    );

    return blogger;
  }

  @Override
  public Blogger findByUsername(String username) {
    return null;
  }

  @Override
  public Blogger findBloggerByLogin(String username, String passsword) {
    return null;
  }
}
