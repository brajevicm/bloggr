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
  List<Blog> findBlogs();

  Blog findByTitle(String title);

  Blog findById(Long id);

  Blog create(BlogForm blogForm);

  Blog edit(Blog blog);

  void deleteByTitle(String title);

  void deleteById(Long id);
}
