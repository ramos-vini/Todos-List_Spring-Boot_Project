package com.example.demo.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String loginPage(@RequestParam(defaultValue = "Vini") String name, Model model){
        model.addAttribute("name", name);

        return "welcome";
    }

}
