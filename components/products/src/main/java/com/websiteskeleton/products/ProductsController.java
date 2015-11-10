package com.websiteskeleton.products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

import static java.util.Arrays.asList;

@Controller
public class ProductsController {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductsController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getProducts() throws JsonProcessingException {
        List<Product> products = new ArrayList<>();
        products.addAll(asList(new Product("Super Glue"), new Product("Kool-Aide")));
        Optional<Product> externalProduct = Optional.empty();

        try {
            String externalProductString = restTemplate.getForObject("http://localhost:6789/external-product", String.class);
            externalProduct = Optional.of(new Product(externalProductString));
        } catch (RestClientException e) {
            // server is down - ignore
        }

        externalProduct.ifPresent(products::add);

        return objectMapper.writeValueAsString(products);
    }
}
