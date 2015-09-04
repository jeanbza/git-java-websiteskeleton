package com.websiteskeleton.products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertySources;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class ProductsController {
    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired PropertySources propertySources;

    public ProductsController() {
        System.out.println(propertySources);
        System.exit(0);
    }

    @RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getProducts() throws JsonProcessingException {
        List<Product> products = asList(
            new Product("Super Glue"),
            new Product("Kool-Aide")
        );

        return jsonMapper.writeValueAsString(products);
    }
}
