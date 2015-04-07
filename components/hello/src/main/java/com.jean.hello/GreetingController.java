package com.jean.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    public GreetingController() {
        System.out.println("wtf");
    }

    @RequestMapping(value = "/fubar")
    @ResponseBody
    public String getHomePage() {
        return "Response!";
    }
}
