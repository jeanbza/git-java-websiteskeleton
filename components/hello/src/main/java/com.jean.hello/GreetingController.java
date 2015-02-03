package com.jean.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@Controller
public class GreetingController {
    @RequestMapping(value = "/")
    public String getHomePage() throws MalformedURLException {
        return "index";
    }
}
