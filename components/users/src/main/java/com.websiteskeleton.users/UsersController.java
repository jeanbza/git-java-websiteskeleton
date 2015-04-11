package com.websiteskeleton.users;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "home";
    }

    @RequestMapping(value = "/users")
    @ResponseBody
    public ResponseEntity<String> getUsers() {
        return new ResponseEntity<>("[" +
            "{\"name\":\"Bob\"}," +
            "{\"name\":\"Sue\"}" +
        "]", getJsonHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getJsonHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return responseHeaders;
    }
}
