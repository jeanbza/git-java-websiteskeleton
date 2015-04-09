package com.websiteskeleton.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    public GreetingController() {
        System.out.println("wtf");
    }

    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String getFoo(Model model) {
        System.out.println("bom");
        return "home";
    }

    @RequestMapping(value = "/users")
    @ResponseBody
    public String getUsers() {
        return "users are here!";
    }
}
