package com.websiteskeleton.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {
    @RequestMapping(value = "/products")
    @ResponseBody
    public String getProducts() {
        return "products are here!";
    }
}
