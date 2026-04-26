package com.ChronosPetWeb.controller;

import org.springframework.ui.Model;
import com.ChronosPetWeb.model.User;
import com.ChronosPetWeb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        Long id = userService.saveUser(user);
        String message = "User `" + id + "` saved successfully!";
        model.addAttribute("message", message);
        return "user/registerUser";
    }
}
