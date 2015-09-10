package com.websiteskeleton.products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class ProductsController {
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final RestTemplate restTemplate;

    @Autowired
    public ProductsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getProducts() throws JsonProcessingException {
        String externalProduct = restTemplate.getForObject("http://localhost:6789/external-product", String.class);

        List<Product> products = asList(new Product("Super Glue"), new Product("Kool-Aide"), new Product(externalProduct));

        return jsonMapper.writeValueAsString(products);
    }
}
