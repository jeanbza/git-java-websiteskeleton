package com.websiteskeleton.products;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {
    @RequestMapping(value = "/products")
    @ResponseBody
    public ResponseEntity<String> getUsers() {
        return new ResponseEntity<>("[" +
            "{\"name\":\"Super Glue\"}," +
            "{\"name\":\"Kool-Aide\"}" +
        "]", getJsonHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getJsonHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return responseHeaders;
    }
}
