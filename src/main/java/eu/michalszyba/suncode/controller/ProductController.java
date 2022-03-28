package eu.michalszyba.suncode.controller;

import eu.michalszyba.suncode.model.Product;
import eu.michalszyba.suncode.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("columns")
    public List<String> populateColumns() {
        List<String> fields = new ArrayList<>();
        for (Field field : Product.class.getDeclaredFields()) {
            fields.add(field.getName());
        }
        return fields;
    }

    @GetMapping("/duplicates")
    public String getDuplicates(@RequestParam("column") String columnName, Model model) {
        model.addAttribute("duplicates", productService.findDuplicates(columnName));
        return "duplicates";
    }

    @GetMapping("/unique")
    public String getUnique(@RequestParam("column") String columnName,  Model model) {
        model.addAttribute("unique", productService.findUnique(columnName));
        return "unique";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

}
