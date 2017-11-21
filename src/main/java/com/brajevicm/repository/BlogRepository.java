package com.brajevicm.repository;

import com.brajevicm.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
public interface BlogRepository {
  List<Blog> findBlogs();

  Blog findByTitle(String title);

  Blog findById(Long id);

  Blog create(Blog blog);
}
