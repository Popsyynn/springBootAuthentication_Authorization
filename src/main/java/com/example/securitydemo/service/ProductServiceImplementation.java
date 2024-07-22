//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.securitydemo.service;

import com.example.securitydemo.entity.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.securitydemo.error.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {
    private static Map<Long, Product> productRepo = new HashMap();

    public ProductServiceImplementation() {
    }

    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    public Collection<Product> getProduct() {
        List<Product> products = new ArrayList(productRepo.values());
        return products;
    }

    public Product getUniqueProduct(Long id) {
        return (Product)productRepo.get(id);
    }

    public void deleteProduct(Long id) {
        productRepo.remove(id);
    }

    public void updateProduct(Long id, Product product) {
        if (!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        } else {
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
        }
    }

    static {
        Product honey = new Product();
        honey.setId(1L);
        honey.setName("Swiss");
        productRepo.put(honey.getId(), honey);
        Product almond = new Product();
        almond.setId(2L);
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }
}
