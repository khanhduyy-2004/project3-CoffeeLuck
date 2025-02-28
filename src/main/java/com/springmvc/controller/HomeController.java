package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.springmvc.dao.UserDao;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userDao.getUsers());
        return "index";
    }
}
