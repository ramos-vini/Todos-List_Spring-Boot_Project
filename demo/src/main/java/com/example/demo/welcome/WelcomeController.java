package com.example.demo.welcome;

import com.example.demo.security.LoggedinUser;
import com.example.demo.security.SpringSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String loginPage(Model model){
        model.addAttribute("username", LoggedinUser.getUsername());

        return "welcome";
    }

}
