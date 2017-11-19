package com.brajevicm.repository;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.Blogger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Repository("blogRepository")
public class BlogRepositoryImpl implements BlogRepository {
  List<Blog> blogs = new ArrayList<Blog>() {{
    new Blog(1L, "Title", "This is the message.", new Blogger(), new Date());
  }};

  @Override
  public List<Blog> findBlogs() {
    return this.blogs;
  }

  @Override
  public Blog findByTitle(String title) {
    return this.blogs.stream()
      .filter(b -> Objects.equals(b.getLink(), title))
      .findFirst()
      .orElse(null);
  }

  @Override
  public Blog findById(Long id) {
    return this.blogs.stream()
      .filter(b -> Objects.equals(b.getId(), id))
      .findFirst()
      .orElse(null);
  }

  @Override
  public Blog create(Blog blog) {
    blog.setCreatedAt(new Date());
    blog.setBlogger(new Blogger());
    blog.setId(this.blogs.stream().mapToLong(
      b -> b.getId()).max().getAsLong() + 1);
    this.blogs.add(blog);

    return blog;
  }

  @Override
  public Blog edit(Blog blog) {
    for (int i = 0; i < this.blogs.size(); i++) {
      if (Objects.equals(this.blogs.get(i).getId(), blog.getId())) {
        this.blogs.set(i, blog);
      }
    }

    return blog;
  }

  @Override
  public void deleteByTitle(String title) {
    for (int i = 0; i < this.blogs.size(); i++) {
      if (Objects.equals(this.blogs.get(i).getLink(), title)) {
        this.blogs.remove(i);
      }
    }
  }

  @Override
  public void deleteById(Long id) {
    for (int i = 0; i < this.blogs.size(); i++) {
      if (Objects.equals(this.blogs.get(i).getId(), id)) {
        this.blogs.remove(i);
      }
    }
  }
}
