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
  private String title;
  private String message;
  private String blogger;
  private Date createdAt;
  private String link;

  public Blog() {
  }

  public Blog(String title, String message) {
    this.title = title;
    this.message = message;
  }

  public Blog(Long id, String title, String message, String blogger, Date createdAt) {
    this.id = id;
    this.title = title;
    this.message = message;
    this.blogger = blogger;
    this.createdAt = createdAt;
  }

  public Blog(Long id, String title, String message, String blogger, Date createdAt, String link) {
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

  public String getBlogger() {
    return blogger;
  }

  public void setBlogger(String blogger) {
    this.blogger = blogger;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
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
      .append(blogger, blog.blogger)
      .append(createdAt, blog.createdAt)
      .append(link, blog.link)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(id)
      .append(title)
      .append(message)
      .append(blogger)
      .append(createdAt)
      .append(link)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "Blog{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", message='" + message + '\'' +
      ", blogger=" + blogger +
      ", createdAt=" + createdAt +
      ", link='" + link + '\'' +
      '}';
  }
}
