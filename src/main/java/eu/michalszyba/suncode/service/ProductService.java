package eu.michalszyba.suncode.service;

import eu.michalszyba.suncode.model.Product;
import eu.michalszyba.suncode.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findDuplicates(String columnName) {
        switch (columnName) {
            case "id":
                return productRepository.findDuplicatesCol0();
            case "kolumna1":
                return productRepository.findDuplicatesCol1();
            case "kolumna2":
                return productRepository.findDuplicatesCol2();
            case "kolumna3":
                return productRepository.findDuplicatesCol3();
            case "kolumna4":
                return productRepository.findDuplicatesCol4();
        }
        return null;
    }

    public List<Product> findUnique(String columnName) {
        switch (columnName) {
            case "id":
                return productRepository.findUniqueCol0();
            case "kolumna1":
                return productRepository.findUniqueCol1();
            case "kolumna2":
                return productRepository.findUniqueCol2();
            case "kolumna3":
                return productRepository.findUniqueCol3();
            case "kolumna4":
                return productRepository.findUniqueCol4();
        }
        return null;
    }
}
