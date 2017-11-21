package com.brajevicm.service;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.form.BloggerForm;
import com.brajevicm.repository.BloggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public interface BloggerService {
  void registerNewBloggerAccount(BloggerForm bloggerForm);

  Blogger findByUsername(Blogger blogger);
}
