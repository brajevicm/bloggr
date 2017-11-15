package com.brajevicm.controller;

import com.brajevicm.entity.Blog;
import com.brajevicm.repository.BlogRepository;
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
    BlogRepository mockBlogRepository = mock(BlogRepository.class);
    Blog unsaved = new Blog("Title", "Message", "Blogger");
    Blog saved = new Blog(24L, "Title", "Message", "Blogger", null, "title");

    when(mockBlogRepository.save(unsaved)).thenReturn(saved);

    BlogController blogController = new BlogController(mockBlogRepository);
    MockMvc mockMvc = standaloneSetup(blogController).build();

    mockMvc.perform(post("/blog/new")
      .param("title", "Title")
      .param("message", "Message")
      .param("blogger", "Blogger"))
      .andExpect(redirectedUrl("/blogs"));

  }

  @Test
  public void showBlogs() throws Exception {

  }

  @Test
  public void showSingleBlog() throws Exception {

  }

}
