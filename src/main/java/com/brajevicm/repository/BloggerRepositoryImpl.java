package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Repository("bloggerRepository")
public class BloggerRepositoryImpl implements BloggerRepository {

  @Override
  public Blogger create(Blogger blogger) {
    return null;
  }

  @Override
  public Blogger findByUsername(String username) {
    return null;
  }

}
