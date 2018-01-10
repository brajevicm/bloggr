package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Repository("bloggerRepository")
public class BloggerRepositoryImpl implements BloggerRepository {

  @Autowired
  SessionFactory sessionFactory;

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
  public Blogger create(Blogger blogger, Role role) {
    blogger = (Blogger) getSession().merge(blogger);
    getSession().merge(role);

    return blogger;
  }

  @Override
  @Transactional
  public Blogger findByUsername(String username) {
    return (Blogger) getSession().createCriteria(Blogger.class)
      .add(Restrictions.eq("username", username))
      .uniqueResult();
  }

}
