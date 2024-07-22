//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.securitydemo.service;

import com.example.securitydemo.entity.Product;
import java.util.Collection;

public interface ProductService {
    void createProduct(Product product);

    Collection<Product> getProduct();

    Product getUniqueProduct(Long id);

    void deleteProduct(Long id);

    void updateProduct(Long id, Product product);
}
