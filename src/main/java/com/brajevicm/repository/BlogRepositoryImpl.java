package com.brajevicm.repository;

import com.brajevicm.entity.Blog;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Repository("blogRepository")
public class BlogRepositoryImpl implements BlogRepository {
  private JdbcOperations jdbc;

  @Inject
  public BlogRepositoryImpl(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public List<Blog> findBlogs() {
    String query = "SELECT blog_id, title, message, blogger, createdAt, link FROM blogs";

    return jdbc.query(query, this::mapBlog);
  }

  @Override
  public Blog findByTitle(String title) {
    String query = "SELECT blog_id, title, message, blogger, createdAt, link FROM blogs WHERE link = ?";

    return jdbc.queryForObject(query, this::mapBlog, title);
  }

  @Override
  public Blog findById(Long id) {
    String query = "SELECT blog_id, title, message, blogger, createdAt, link FROM blogs WHERE blog_id = ?";

    return jdbc.queryForObject(query, this::mapBlog, id);
  }

  @Override
  public Blog create(Blog blog) {
    String query = "INSERT INTO blogs (title, link, message, blogger)" +
      "VALUES (?, ?, ?, ?)";
    jdbc.update(query,
      blog.getTitle(),
      blog.getLink(),
      blog.getMessage(),
      blog.getBlogger()
    );

    return blog;
  }

  private Blog mapBlog(ResultSet resultSet, int row) throws SQLException {
    return new Blog(
      resultSet.getLong("blog_id"),
      resultSet.getString("title"),
      resultSet.getString("message"),
      resultSet.getString("blogger"),
      resultSet.getTimestamp("createdAt"),
      resultSet.getString("link")
    );
  }

}
