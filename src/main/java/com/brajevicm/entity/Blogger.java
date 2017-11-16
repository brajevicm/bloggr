package com.brajevicm.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public class Blogger {
  private Long id;
  private String username;
  private String passwordHash;
  private String firstName;
  private String lastName;
  private String createdAt;
  private Set<Blog> blogs = new HashSet<>();

  public Blogger() {
  }

  public Blogger(String username, String passwordHash, String firstName, String lastName) {
    this.username = username;
    this.passwordHash = passwordHash;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Blogger(Long id, String username, String passwordHash, String firstName, String lastName, String createdAt, Set<Blog> blogs) {
    this.id = id;
    this.username = username;
    this.passwordHash = passwordHash;
    this.firstName = firstName;
    this.lastName = lastName;
    this.createdAt = createdAt;
    this.blogs = blogs;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Set<Blog> getBlogs() {
    return blogs;
  }

  public void setBlogs(Set<Blog> blogs) {
    this.blogs = blogs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Blogger blogger = (Blogger) o;

    return new EqualsBuilder()
      .append(id, blogger.id)
      .append(username, blogger.username)
      .append(passwordHash, blogger.passwordHash)
      .append(firstName, blogger.firstName)
      .append(lastName, blogger.lastName)
      .append(createdAt, blogger.createdAt)
      .append(blogs, blogger.blogs)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(id)
      .append(username)
      .append(passwordHash)
      .append(firstName)
      .append(lastName)
      .append(createdAt)
      .append(blogs)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "Blogger{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", passwordHash='" + passwordHash + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", createdAt='" + createdAt + '\'' +
      ", blogs=" + blogs +
      '}';
  }
}
