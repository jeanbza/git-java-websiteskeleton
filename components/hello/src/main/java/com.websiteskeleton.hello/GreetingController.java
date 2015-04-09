package com.websiteskeleton.hello;

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
        return "index";
    }

    @RequestMapping(value = "/fubar")
    @ResponseBody
    public String getFubar() {
        return "Fubar!";
    }
}
