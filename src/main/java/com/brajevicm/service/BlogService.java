package com.brajevicm.service;

import com.brajevicm.entity.Blog;
import com.brajevicm.repository.BlogRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
      new Blog(
        "Christian Eriksen: On Tottenham transformation",
        "A lot has happened in the last few years,\" Christian Eriksen tells Sky Sports. " +
          "Over the next few days the 25-year-old will contest a make-or-break World Cup play-off with " +
          "Denmark against the Republic of Ireland and a potentially explosive north London derby with Tottenham " +
          "against Arsenal, but first he pauses to reflect on the journey so far.\n" +
          "\n" +
          "It is over four years since he arrived at Spurs as one of seven new signings intended to offset " +
          "Gareth Bale's departure to Real Madrid. Players and managers came and went in the tumultuous period that " +
          "followed, but Eriksen's place was never in doubt. He is now one of the club's longest-serving players" +
          " and a talismanic figure in their remarkable transformation under Mauricio Pochettino.",
        "Eriksen001"
      )
    );
    blogList.add(
      new Blog(
        "Lionel Messi: On Barcelona",
        "A lot has happened in the last few years,\" Christian Eriksen tells Sky Sports. " +
          "Over the next few days the 25-year-old will contest a make-or-break World Cup play-off with " +
          "Denmark against the Republic of Ireland and a potentially explosive north London derby with Tottenham " +
          "against Arsenal, but first he pauses to reflect on the journey so far.\n" +
          "\n" +
          "It is over four years since he arrived at Spurs as one of seven new signings intended to offset " +
          "Gareth Bale's departure to Real Madrid. Players and managers came and went in the tumultuous period that " +
          "followed, but Eriksen's place was never in doubt. He is now one of the club's longest-serving players" +
          " and a talismanic figure in their remarkable transformation under Mauricio Pochettino.",
        "Messi123"
      )
    );
  }

  @Override
  public List<Blog> findBlogs() {
    return blogList;
  }

  @Override
  public Blog findBlogByName(String title) {
    Blog blog = null;
    for (Blog tempBlog :
      blogList) {
      if (tempBlog.getLink().equals(title)) {
        blog = tempBlog;
      }
    }

    return blog;
  }

  @Override
  public Blog save(Blog blog) {
    blogList.add(blog);

    return blog;
  }
}
