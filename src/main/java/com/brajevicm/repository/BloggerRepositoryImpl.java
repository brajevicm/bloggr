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
  private JdbcOperations jdbc;

  @Inject
  public BloggerRepositoryImpl(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Blogger create(Blogger blogger) {
    String query = "INSERT INTO bloggers (username, password, firstName, lastName)" +
      " VALUES (?, ?, ?, ?)";
    String queryForRole = "INSERT INTO blogger_roles (username, role)" +
      "VALUES (?, ?)";
    jdbc.update(query,
      blogger.getUsername(),
      blogger.getPassword(),
      blogger.getFirstName(),
      blogger.getLastName()
    );

    jdbc.update(queryForRole,
      blogger.getUsername(),
      "ROLE_USER"
    );

    return blogger;
  }

  @Override
  public Blogger findByUsername(String username) {
    String query = "SELECT username, firstName, lastName FROM bloggers WHERE username = ?";
    return jdbc.queryForObject(query, this::mapBlogger, username);
  }

  private Blogger mapBlogger(ResultSet resultSet, int row) throws SQLException {
    return new Blogger(
      resultSet.getLong("blogger_id"),
      resultSet.getString("username"),
      null,
      resultSet.getString("firstName"),
      resultSet.getString("lastName"),
      resultSet.getTimestamp("createdAt")
    );
  }
}
