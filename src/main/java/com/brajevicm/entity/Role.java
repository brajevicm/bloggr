package com.brajevicm.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "blogger_roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "blogger_role_id")
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "role")
  private String role;

  public Role() {
  }

  public Role(String username, String role) {
    this.username = username;
    this.role = role;
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Role that = (Role) o;

    return new EqualsBuilder()
      .append(id, that.id)
      .append(username, that.username)
      .append(role, that.role)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .append(id)
      .append(username)
      .append(role)
      .toHashCode();
  }

  @Override
  public String toString() {
    return "Role{" +
      "id=" + id +
      ", username=" + username +
      ", role='" + role + '\'' +
      '}';
  }
}
