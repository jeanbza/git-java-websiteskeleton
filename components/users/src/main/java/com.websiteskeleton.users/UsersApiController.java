package com.websiteskeleton.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class UsersApiController {
    private final ObjectMapper jsonMapper = new ObjectMapper();
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
