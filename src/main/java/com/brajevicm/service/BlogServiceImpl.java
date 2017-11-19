package com.brajevicm.service;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.form.BlogForm;
import com.brajevicm.repository.BlogRepository;
import com.brajevicm.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
  private BlogRepository blogRepository = new BlogRepositoryImpl();

  @Override
  public List<Blog> findBlogs() {
    return blogRepository.findBlogs();
  }

  @Override
  public Blog findByTitle(String title) {
    return blogRepository.findByTitle(title);
  }

  @Override
  public Blog findById(Long id) {
    return blogRepository.findById(id);
  }

  @Override
  public Blog create(BlogForm blogForm) {
    String titleForUrl = blogForm.getTitle().replace(' ', '-').toLowerCase();

    Blog blog = new Blog();
    blog.setTitle(blogForm.getTitle());
    blog.setMessage(blogForm.getMessage());
    blog.setLink(titleForUrl);

    return blogRepository.create(blog);
  }

  @Override
  public Blog edit(Blog blog) {
    return blogRepository.edit(blog);
  }

  @Override
  public void deleteByTitle(String title) {
    blogRepository.deleteByTitle(title);
  }

  @Override
  public void deleteById(Long id) {
    blogRepository.deleteById(id);
  }
}
