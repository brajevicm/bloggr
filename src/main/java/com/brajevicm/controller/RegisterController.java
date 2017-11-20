package com.brajevicm.controller;

import com.brajevicm.entity.form.BloggerForm;
import com.brajevicm.service.BloggerService;
import com.brajevicm.service.BloggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Controller
public class RegisterController {
  @Autowired
  private BloggerService bloggerService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new BloggerForm());

    return "registerForm";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String processRegisterForm(@Valid @ModelAttribute BloggerForm bloggerForm, BindingResult bindingResult) {
    bloggerService.registerNewBloggerAccount(bloggerForm);
    if (bindingResult.hasErrors()) {
      return "registerForm";
    }

    return "redirect:/login?register";
  }
}
