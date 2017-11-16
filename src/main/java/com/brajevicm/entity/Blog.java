package com.brajevicm.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
public class Blog {
  private Long id;

  @NotNull
  @Size(min = 3, max = 25, message = "{blog.title.size}")
  private String title;

  @NotNull
  @Size(min = 10, max = 280, message = "{blog.message.size}")
  private String message;

  @NotNull
  private Date createdAt;

  @NotNull
  @Size(min = 2, max = 20, message = "{blog.blogger.size}")
  private Blogger blogger;

  @NotNull
  @Size(min = 3, max = 25)
  private String link;

  public Blog() {
  }

  public Blog(String title, String message) {
    this(null, title, message, new Blogger(), new Date(), title.replace(' ', '-').toLowerCase());
  }

  public Blog(String title, String message, Blogger blogger) {
    this(null, title, message, blogger, new Date(), title.replace(' ', '-').toLowerCase());
  }

  public Blog(Long id, String title, String message, Blogger blogger) {
    this(id, title, message, blogger, new Date(), title.replace(' ', '-').toLowerCase());
  }

  public Blog(Long id, String title, String message, Blogger blogger, Date createdAt, String link) {
    this.id = id;
    this.title = title;
    this.message = message;
    this.blogger = blogger;
    this.createdAt = createdAt;
    this.link = link;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Blogger getBlogger() {
    return blogger;
  }

  public void setBlogger(Blogger blogger) {
    this.blogger = blogger;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Blog blog = (Blog) o;

    return new EqualsBuilder()
      .append(id, blog.id)
      .append(title, blog.title)
      .append(message, blog.message)
      .append(createdAt, blog.createdAt)
      .append(blogger, blog.blogger)
      .append(link, blog.link)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(id)
      .append(title)
      .append(message)
      .append(createdAt)
      .append(blogger)
      .append(link)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "Blog{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", message='" + message + '\'' +
      ", createdAt=" + createdAt +
      ", blogger='" + blogger + '\'' +
      ", link='" + link + '\'' +
      '}';
  }
}
