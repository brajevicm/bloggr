package com.brajevicm.repository;

import com.brajevicm.entity.Blog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  @Override
  @Transactional
  public List<Blog> findBlogs() {
    return (List<Blog>) getSession().createCriteria(Blog.class).list();
  }

  @Override
  @Transactional
  public Blog findByTitle(String title) {
    return (Blog) getSession().createCriteria(Blog.class)
      .add(Restrictions.eq("title", title))
      .uniqueResult();
  }

  @Override
  @Transactional
  public Blog findById(Long id) {
    return (Blog) getSession().createCriteria(Blog.class)
      .add(Restrictions.eq("id", id))
      .uniqueResult();
  }

  @Override
  @Transactional
  public Blog create(Blog blog) {
    return (Blog) getSession().merge(blog);
  }
}
