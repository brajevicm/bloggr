package com.brajevicm.controller;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.form.BlogForm;
import com.brajevicm.repository.BlogRepository;
import com.brajevicm.service.BlogService;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public class BlogControllerTest {
  @Test
  public void shouldShowForm() throws Exception {
    BlogController blogController = new BlogController();
    MockMvc mockMvc = standaloneSetup(blogController).build();

    mockMvc.perform(get("/blog/new"))
      .andExpect(view().name("blogForm"))
      .andExpect(model().attributeExists("blogForm"));
  }

  @Test
  public void shouldProcessForm() throws Exception {
    BlogService mockBlogService = mock(BlogService.class);

    BlogForm blogForm = new BlogForm();
    blogForm.setMessage("Message");
    blogForm.setTitle("Title");

    Blog blog = new Blog(24L, "Title", "Message", "milos", new Date(), "title");

    when(mockBlogService.create(blogForm)).thenReturn(blog);

    BlogController blogController = new BlogController(mockBlogService);
    MockMvc mockMvc = standaloneSetup(blogController).build();

    mockMvc.perform(post("/blog/new")
      .param("title", "Title")
      .param("message", "Message"))
      .andExpect(redirectedUrl("/blogs"));

  }

  @Test
  public void showBlogs() throws Exception {

  }

  @Test
  public void showSingleBlog() throws Exception {

  }

}
