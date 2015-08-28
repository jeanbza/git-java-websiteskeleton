package com.websiteskeleton.users;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    // TODO: Move to more appropriate place
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "home";
    }

    // TODO: Move to more appropriate place
    // TODO: Needs a unit test
    @RequestMapping(value = "/health")
    @ResponseBody
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("OK", getJsonHeaders(), HttpStatus.OK);
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
