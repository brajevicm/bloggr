package com.brajevicm.service;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.Blogger;
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
@Service
public class BlogService implements BlogRepository {
  private List<Blog> blogList = new ArrayList<>();

  public BlogService() {
    blogList.add(
      new Blog(1L, "Christian Eriksen: On Tottenham transformation",
        "A lot has happened in the last few years, Christian Eriksen tells Sky Sports. " +
          "Over the next few days the 25-year-old will contest a make-or-break World Cup play-off with " +
          "Denmark against the Republic of Ireland and a potentially explosive north London derby with Tottenham",
        new Blogger("eriksen121", "123", "Christan", "Eriksen"))
    );
    blogList.add(
      new Blog(2L, "Lionel Messi: On Tottenham transformation",
        "A lot has happened in the last few years, Christian Eriksen tells Sky Sports. " +
          "Over the next few days the 25-year-old will contest a make-or-break World Cup play-off with " +
          "Denmark against the Republic of Ireland and a potentially explosive north London derby with Tottenham",
        new Blogger("messilionel", "123", "Lionel", "Messi"))
    );
    blogList.add(
      new Blog(3L, "Harry Kane: On Tottenham transformation",
        "A lot has happened in the last few years, Christian Eriksen tells Sky Sports. " +
          "Over the next few days the 25-year-old will contest a make-or-break World Cup play-off with " +
          "Denmark against the Republic of Ireland and a potentially explosive north London derby with Tottenham",
        new Blogger("messilionel", "123", "Lionel", "Messi"))
    );
    blogList.add(
      new Blog(4L, "Iniesta: On Tottenham transformation",
        "A lot has happened in the last few years, Christian Eriksen tells Sky Sports. " +
          "Over the next few days the 25-year-old will contest a make-or-break World Cup play-off with " +
          "Denmark against the Republic of Ireland and a potentially explosive north London derby with Tottenham",
        new Blogger("messilionel", "123", "Lionel", "Messi"))
    );
  }

  @Override
  public List<Blog> findBlogs() {
    return blogList;
  }

  @Override
  public Blog findByTitle(String title) {
    return this.blogList.stream()
      .filter(b -> Objects.equals(b.getLink(), title))
      .findFirst()
      .orElse(null);
  }

  @Override
  public Blog findById(Long id) {
    return this.blogList.stream()
      .filter(blog -> Objects.equals(blog.getId(), id))
      .findFirst()
      .orElse(null);
  }

  @Override
  public Blog create(Blog blog) {
    blog.setId(this.blogList.stream().mapToLong(
      b -> b.getId()).max().getAsLong() + 1);
    this.blogList.add(blog);

    return blog;
  }

  @Override
  public Blog edit(Blog blog) {
    for (int i = 0; i < this.blogList.size(); i++) {
      if (Objects.equals(this.blogList.get(i).getId(), blog.getId())) {
        this.blogList.set(i, blog);
      }
    }

    return blog;
  }

  @Override
  public void deleteByTitle(String title) {
    for (int i = 0; i < this.blogList.size(); i++) {
      if (Objects.equals(this.blogList.get(i).getLink(), title)) {
        this.blogList.remove(i);
      }
    }
  }

  @Override
  public void deleteById(Long id) {
    for (int i = 0; i < this.blogList.size(); i++) {
      if (Objects.equals(this.blogList.get(i).getId(), id)) {
        this.blogList.remove(i);
      }
    }
  }
}
