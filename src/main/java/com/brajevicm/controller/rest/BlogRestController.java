package com.brajevicm.controller.rest;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.form.BlogForm;
import com.brajevicm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  BlogService blogService;

  @RequestMapping(value = "/api/blogs", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Blog>> getBlogs() {
    List<Blog> blogs = blogService.findBlogs();
    if (blogs.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(blogs, HttpStatus.OK);
  }

  @RequestMapping(value = "/api/blogs", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Blog>> createNewBlog(@RequestBody BlogForm blogForm) {
    blogService.create(blogForm);
    HttpHeaders headers = new HttpHeaders();

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/api/blog/{blogTitle}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Blog> getBlogByTitle(@PathVariable String blogTitle) {
    Blog blog = blogService.findByTitle(blogTitle);
    if (blog == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(blog, HttpStatus.OK);
  }

  @RequestMapping(value = "/api/blog/{blogTitle}", method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Blog> updateBlogByTitle(@RequestBody Blog blog) {
    blogService.update(blog);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/api/blog/{blogTitle}", method = RequestMethod.DELETE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Blog> deleteBlogByTitle(@PathVariable String blogTitle) {
    Blog blog = blogService.findByTitle(blogTitle);

    if (blog == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    blogService.delete(blog);

    return new ResponseEntity<>(blog, HttpStatus.OK);
  }

}
