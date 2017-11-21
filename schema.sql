CREATE TABLE bloggers (
  blogger_id BIGINT      NOT NULL AUTO_INCREMENT UNIQUE,
  username   VARCHAR(30) NOT NULL,
  password   VARCHAR(30) NOT NULL,
  firstName  VARCHAR(30) NOT NULL,
  lastName   VARCHAR(30) NOT NULL,
  createdAt  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  enabled    TINYINT     NOT NULL DEFAULT 1,
  UNIQUE KEY (username, blogger_id),
  PRIMARY KEY (username)
);

CREATE TABLE blogger_roles (
  blogger_role_id BIGINT      NOT NULL AUTO_INCREMENT,
  username        VARCHAR(30) NOT NULL,
  role            VARCHAR(30) NOT NULL,
  PRIMARY KEY (blogger_role_id),
  UNIQUE KEY uni_username_role (role, username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES bloggers (username)
);

CREATE TABLE blogs (
  blog_id   BIGINT       NOT NULL AUTO_INCREMENT,
  title     VARCHAR(15)  NOT NULL,
  link      VARCHAR(15)  NOT NULL,
  message   VARCHAR(255) NOT NULL,
  blogger   VARCHAR(30)  NOT NULL,
  createdAt TIMESTAMP    NOT NULL,
  PRIMARY KEY (blog_id),
  UNIQUE KEY uni_blog_id (blog_id),
  KEY fk_blogger (blogger),
  CONSTRAINT fk_blogger FOREIGN KEY (blogger) REFERENCES bloggers (username)
);


INSERT INTO bloggers (username, password, firstName, lastName, enabled)
VALUES ('milos', 'milos', 'Milos', 'Brajevic', TRUE);
INSERT INTO bloggers (username, password, firstName, lastName, enabled)
VALUES ('admin', 'admin', 'Admin', 'Admin', TRUE);


INSERT INTO blogger_roles (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO blogger_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO blogger_roles (username, role)
VALUES ('milos', 'ROLE_USER');


INSERT INTO blogs (title, link, message, blogger)
VALUES ('Title', 'title', 'Message', 'milos');