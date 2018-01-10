package com.brajevicm.service;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.form.BlogForm;
import com.brajevicm.repository.BlogRepository;
import com.brajevicm.repository.BlogRepositoryImpl;
import com.brajevicm.repository.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Service
public class BlogServiceImpl implements BlogService {
  @Autowired
  private BlogRepository blogRepository;

  @Autowired
  private BloggerRepository bloggerRepository;

  //  @TODO
  @Override
  public void deleteByTitle(String title) {

  }

  @Override
  public List<Blog> findBlogs() {
    return blogRepository.findBlogs();
  }

  @Override
  public Blog findByTitle(String title) {
    return blogRepository.findByTitle(title);
  }

  //  @TODO
  @Override
  public Blog update(Blog blog) {
    return null;
  }

  @Override
  public Blog findById(Long id) {
    return blogRepository.findById(id);
  }

  @Override
  public Blog create(BlogForm blogForm) {
    String titleForUrl = blogForm.getTitle().replace(' ', '-').toLowerCase();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String bloggerUsername = auth.getName();
    Blogger blogger = bloggerRepository.findByUsername(bloggerUsername);

    Blog blog = new Blog();
    blog.setTitle(blogForm.getTitle());
    blog.setMessage(blogForm.getMessage());
    blog.setLink(titleForUrl);
    blog.setBlogger(blogger);

    return blogRepository.create(blog);
  }
}
