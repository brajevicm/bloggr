package com.brajevicm.service;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.form.BlogForm;
import com.brajevicm.repository.BlogRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
public interface BlogService {
  void delete(Blog blog);

  void update(Blog blog);

  List<Blog> findBlogs();

  Blog create(BlogForm blogForm);

  Blog findById(Long id);

  Blog findByTitle(String title);
}
