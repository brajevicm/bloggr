package com.brajevicm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    14-Nov-17
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

  @RequestMapping(method = RequestMethod.GET)
  public String getHome() {
    return "index";
  }
}
