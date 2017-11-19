package com.brajevicm.repository;

import com.brajevicm.entity.Blogger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Repository("bloggerRepository")
public class BloggerRepositoryImpl implements BloggerRepository {
  List<Blogger> bloggers = new ArrayList<Blogger>() {{
    new Blogger("milos", "milos123", "Milos", "Brajevic");
  }};

  @Override
  public Blogger create(Blogger blogger) {
    blogger.setId(this.bloggers.stream().mapToLong(
      b -> b.getId()).max().getAsLong() + 1);
    this.bloggers.add(blogger);

    return blogger;
  }

  @Override
  public Blogger findByUsername(String username) {
    return bloggers.stream()
      .filter(b -> Objects.equals(b.getUsername(), username))
      .findFirst()
      .orElse(null);
  }

  @Override
  public Blogger findBloggerByLogin(String username, String passsword) {
    return this.bloggers.stream().filter(
      b -> Objects.equals(b.getUsername(), username) && Objects.equals(b.getPassword(), passsword))
      .findFirst()
      .orElse(null);
  }
}
