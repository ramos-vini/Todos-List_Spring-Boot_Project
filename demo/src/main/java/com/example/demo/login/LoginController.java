package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    AuthenticationService auth;

    @GetMapping("login")
    public String loginPage(@RequestParam(defaultValue = "my friend") String name, Model model){
        model.addAttribute("name", name);

        return "login";
    }

    @PostMapping("login")
    public String welcomePage(@RequestParam String name, @RequestParam String password, Model model){
        model.addAttribute("name", name.toLowerCase());
        model.addAttribute("password", password);

        if (auth.authenticate(name, password)){
            return "welcome";
        }

        model.addAttribute("errorMsg", "Username and Password do not match.");
        return "login";
    }
}
