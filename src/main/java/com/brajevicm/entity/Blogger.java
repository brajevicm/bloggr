package com.brajevicm.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
@Entity
@Table(name = "bloggers")
public class Blogger {

  @Column(name = "blogger_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Id
  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "createdAt")
  private Date createdAt;

  @Column(name = "enabled")
  private int enabled;

  public Blogger() {
  }

  public Blogger(String username, String password, String firstName, String lastName) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled() {
    enabled = 1;
  }

  public void setDisabled() {
    enabled = 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Blogger blogger = (Blogger) o;

    return new EqualsBuilder()
      .append(enabled, blogger.enabled)
      .append(id, blogger.id)
      .append(username, blogger.username)
      .append(password, blogger.password)
      .append(firstName, blogger.firstName)
      .append(lastName, blogger.lastName)
      .append(createdAt, blogger.createdAt)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(id)
      .append(username)
      .append(password)
      .append(firstName)
      .append(lastName)
      .append(createdAt)
      .append(enabled)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "Blogger{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", createdAt=" + createdAt +
      ", enabled=" + enabled +
      '}';
  }
}
