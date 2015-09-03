package com.websiteskeleton.users;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersUiController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "home";
    }

    @RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getHealth() {
        return "OK";
    }
}
