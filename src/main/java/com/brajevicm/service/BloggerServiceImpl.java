package com.brajevicm.service;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.form.BloggerForm;
import com.brajevicm.repository.BloggerRepository;
import com.brajevicm.repository.BloggerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
  @Autowired
  private BloggerRepository bloggerRepository;

  @Override
  public Blogger registerNewBloggerAccount(BloggerForm bloggerForm) {
    Blogger blogger = new Blogger();
    blogger.setFirstName(bloggerForm.getFirstName());
    blogger.setLastName(bloggerForm.getLastName());
    blogger.setUsername(bloggerForm.getUsername());
    blogger.setPassword(bloggerForm.getPassword());

    return bloggerRepository.create(blogger);
  }

  @Override
  public Blogger validateBlogger(BloggerForm bloggerForm) {
    return bloggerRepository.findBloggerByLogin(bloggerForm.getUsername(), bloggerForm.getPassword());
  }
}
