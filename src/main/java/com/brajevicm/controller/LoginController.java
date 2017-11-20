package com.brajevicm.controller;

import com.brajevicm.entity.Blogger;
import com.brajevicm.entity.form.BloggerForm;
import com.brajevicm.service.BloggerService;
import com.brajevicm.service.BloggerServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    18-Nov-17
 */
@Controller
public class LoginController {
  private BloggerService bloggerService = new BloggerServiceImpl();

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginForm(Model model) {
    model.addAttribute(new BloggerForm());

    return "loginForm";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String processLoginForm(@Valid @ModelAttribute BloggerForm bloggerForm, BindingResult bindingResult,
                                 @RequestParam(value = "error", required = false) String error,
                                 @RequestParam(value = "logout", required = false) String logout,
                                 @RequestParam(value = "register", required = false) String register,
                                 Model model) {
    if (bindingResult.hasErrors()) {
      return "loginForm";
    }

    if (error != null) {
      model.addAttribute("username", "message.loginError");
      return "loginForm";
    }

    if (logout != null) {
      model.addAttribute("logout", "message.logoutSuccess");
      return "loginForm";
    }

    if (register != null) {
      model.addAttribute("register", "message.registerSuccess");
      return "loginForm";
    }

    return "redirect:/";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }

    return "redirect:/login?logout";
  }

}
