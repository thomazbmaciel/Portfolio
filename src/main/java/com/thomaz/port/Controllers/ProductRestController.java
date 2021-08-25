package com.thomaz.port.Controllers;

import java.util.Map;
import java.util.Optional;

import com.thomaz.port.Models.Product;
import com.thomaz.port.Models.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @PostMapping("/new")
    public String create(@RequestBody Product product){
        productRepository.save(product);
        return "Product " + product.getProductName() + " was created successfully.";
    }

    @PutMapping("/update")
    public String update(@RequestBody Product product){
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        if(existingProduct.isPresent()){
            productRepository.save(product);
            return "Product " + product.getProductName() + " was updated successfully.";
        }
        else {
            return "Product does not exist";
        }
        
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Map<String, Integer> json){
        Integer id = json.get("id");
        productRepository.deleteById(id);
        return "Product was deleted.";
    }

}
