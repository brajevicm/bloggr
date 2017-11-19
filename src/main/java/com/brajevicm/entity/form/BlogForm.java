package com.brajevicm.entity.form;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
public class BlogForm {

  @NotNull
  @Size(min = 3, max = 25, message = "{blog.title.size}")
  private String title;

  @NotNull
  @Size(min = 10, max = 280, message = "{blog.message.size}")
  private String message;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    BlogForm blogForm = (BlogForm) o;

    return new EqualsBuilder()
      .append(title, blogForm.title)
      .append(message, blogForm.message)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(title)
      .append(message)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "BlogForm{" +
      "title='" + title + '\'' +
      ", message='" + message + '\'' +
      '}';
  }
}
