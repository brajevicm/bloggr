package com.brajevicm.entity.form;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public class BloggerForm implements Serializable {

  @NotNull
  @Size(min = 2, max = 20)
  private String firstName;

  @Size(min = 2, max = 20)
  private String lastName;

  @Size(min = 5, max = 20)
  private String username;

  @Size(min = 8, max = 30)
  private String password;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    BloggerForm that = (BloggerForm) o;

    return new EqualsBuilder()
      .append(firstName, that.firstName)
      .append(lastName, that.lastName)
      .append(username, that.username)
      .append(password, that.password)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(firstName)
      .append(lastName)
      .append(username)
      .append(password)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "BloggerForm{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      '}';
  }
}
