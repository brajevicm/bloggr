package com.brajevicm.service;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.Role;
import com.brajevicm.entity.form.BloggerForm;
import com.brajevicm.repository.BloggerRepository;
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
  public void registerNewBloggerAccount(BloggerForm bloggerForm) {
    Blogger blogger = new Blogger();
    blogger.setFirstName(bloggerForm.getFirstName());
    blogger.setLastName(bloggerForm.getLastName());
    blogger.setUsername(bloggerForm.getUsername());
    blogger.setPassword(bloggerForm.getPassword());
    blogger.setEnabled();

    Role role = new Role(blogger.getUsername(), "ROLE_USER");

    bloggerRepository.create(blogger, role);
  }

  @Override
  public Blogger findByUsername(Blogger blogger) {
    return bloggerRepository.findByUsername(blogger.getUsername());
  }

}
