package com.brajevicm.controller;

import com.brajevicm.entity.Blog;
import com.brajevicm.entity.form.BlogForm;
import com.brajevicm.exception.BlogNotFoundException;
import com.brajevicm.service.BlogService;
import com.brajevicm.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
@Controller
public class BlogController {
  @Autowired
  private BlogService blogService;

  public BlogController() {
  }

  @Autowired
  public BlogController(BlogService blogService) {
    this.blogService = blogService;
  }

  @RequestMapping(value = "/blog/new", method = RequestMethod.GET)
  public String getBlogForm(Model model) {
    model.addAttribute(new BlogForm());

    return "blogForm";
  }

  @RequestMapping(value = "/blog/new", method = RequestMethod.POST)
  public String processBlogForm(@ModelAttribute("blogForm") @Valid BlogForm blogForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "blogForm";
    }
    blogService.create(blogForm);

    return "redirect:/blogs";
  }

  @RequestMapping(value = "/blogs", method = RequestMethod.GET)
  public String getBlogs(Model model) {
    model.addAttribute(blogService.findBlogs());

    return "blogs";
  }

  @RequestMapping(value = "/blog/{blogTitle}", method = RequestMethod.GET)
  public String getBlog(@PathVariable String blogTitle, Model model) {
    Blog blog = blogService.findByTitle(blogTitle);
    if (blog == null) {
      throw new BlogNotFoundException();
    }
    model.addAttribute(blog);

    return "blog";
  }

}
