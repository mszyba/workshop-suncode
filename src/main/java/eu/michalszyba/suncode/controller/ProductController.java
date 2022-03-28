package eu.michalszyba.suncode.controller;

import eu.michalszyba.suncode.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/duplicates/{columnName}")
    public String showDuplicates(Model model, @PathVariable String columnName) {
        model.addAttribute("duplicates", productService.findDuplicates(columnName));
        return "duplicates";
    }

    @GetMapping("/unique/{columnName}")
    public String shoqUnique(Model model, @PathVariable String columnName) {
        model.addAttribute("unique", productService.findUnique(columnName));
        return "unique";
    }

    @GetMapping("/home/all")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }
}
