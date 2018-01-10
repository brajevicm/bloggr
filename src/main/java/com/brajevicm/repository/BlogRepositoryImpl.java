package com.brajevicm.repository;

import com.brajevicm.entity.Blog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

  @Autowired
  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  @Override
  @Transactional
  public List<Blog> findBlogs() {
    return (List<Blog>) getSession().createQuery("from Blog").list();
  }

  @Override
  @Transactional
  public Blog findByTitle(String title) {
    return null;
  }

  @Override
  public Blog findById(Long id) {
    return null;
  }

  @Override
  public Blog create(Blog blog) {
    return null;
  }
}
