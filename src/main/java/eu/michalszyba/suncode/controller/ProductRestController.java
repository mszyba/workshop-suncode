package eu.michalszyba.suncode.controller;

import eu.michalszyba.suncode.model.Product;
import eu.michalszyba.suncode.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductRestController {

    private Logger logger = LoggerFactory.getLogger(ProductRestController.class);
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

//    @ModelAttribute("columns")
    @GetMapping("/columns")
    public List<String> populateColumns() {
        List<String> fields = new ArrayList<>();
        for (Field field : Product.class.getDeclaredFields()) {
            fields.add(field.getName());
        }
        return fields;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        try {
            Iterable<Product> products = productService.findAll();
            logger.debug(String.valueOf(productService.findAll().get(1).getKolumna1()));
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/hello")
//    public String hello() {
//        return "Full STACK JAVA MICHAL";
//    }

//    @GetMapping("/prod")
//    public List<Product> getProd() {
//        List<Product> productList = productService.findAll();
//        return productList;
//    }
}
