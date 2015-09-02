package com.websiteskeleton.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class UsersController {
    private final ObjectMapper jsonMapper = new ObjectMapper();

    // TODO: Move to more appropriate place
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "home";
    }

    // TODO: Move to more appropriate place
    // TODO: Needs a unit test
    @RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getUsers() throws JsonProcessingException {
        List<User> users = asList(
            new User("Bob"),
            new User("Sue")
        );

        return jsonMapper.writeValueAsString(users);
    }
}
