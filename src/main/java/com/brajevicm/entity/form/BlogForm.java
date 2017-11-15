package com.brajevicm.entity.form;

import com.brajevicm.entity.Blog;
import org.hibernate.validator.constraints.NotEmpty;

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

  @NotNull
  @Size(min = 2, max = 20, message = "{blog.blogger.size}")
  private String blogger;

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

  public Blog toBlog() {
    return new Blog(this.title, this.message, this.blogger);
  }

  @Override
  public String toString() {
    return "BlogForm{" +
      "title='" + title + '\'' +
      ", message='" + message + '\'' +
      ", blogger='" + blogger + '\'' +
      '}';
  }
}
