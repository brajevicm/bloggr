package com.brajevicm.controller.rest;

import com.brajevicm.entity.Blog;
import com.brajevicm.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    10-Jan-18
 */
@RestController
public class BlogRestController {
  @Autowired
  BlogRepository blogRepository;

  @RequestMapping(value = "/api/blogs", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Blog>> getBlogs() {
    List<Blog> blogs = blogRepository.findBlogs();
    if (blogs.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(blogs, HttpStatus.OK);
  }

  // @TODO
  @RequestMapping(value = "/api/blogs", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Blog>> createNewBlog() {
    return null;
  }

  @RequestMapping(value = "/api/blog/{blogTitle}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Blog> getBlogByTitle(@PathVariable String blogTitle) {
    Blog blog = blogRepository.findByTitle(blogTitle);
    if (blog == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(blog, HttpStatus.OK);
  }

  // @TODO
  @RequestMapping(value = "/api/blog/{blogTitle}", method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Blog> updateBlogByTitle(@PathVariable String blogTitle) {
    return null;
  }

  // @TODO
  @RequestMapping(value = "/api/blog/{blogTitle}", method = RequestMethod.DELETE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Blog> deleteBlogByTitle(@PathVariable String blogTitle) {
    return null;
  }

}
