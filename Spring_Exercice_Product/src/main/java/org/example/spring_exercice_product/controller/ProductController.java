package org.example.spring_exercice_product.controller;




import org.example.spring_exercice_product.model.Product;
import org.example.spring_exercice_product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "list";
    }


    @GetMapping("/detail/{productId}")
    public String detailProduct(@PathVariable("productId") int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/search")
    public String showProduct(@RequestParam("productName") String name,Model model) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            model.addAttribute("product", product);
            return "detail";
        } else {
            return "home";
        }
    }

        @GetMapping("/filter")
        public String filterProducts(
                @RequestParam(value = "category", required = false) String category, Model model,
                @RequestParam(value = "maxprice", required = false) Double maxprice) {
            List<Product> filterProducts = productService.filterProducts(category, maxprice);
            model.addAttribute("products", filterProducts);
            return "list";
        }

    }


