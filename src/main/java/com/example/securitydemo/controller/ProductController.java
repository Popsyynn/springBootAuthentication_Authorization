//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.securitydemo.controller;

import com.example.securitydemo.controller.ProductController;
import com.example.securitydemo.entity.Product;
import com.example.securitydemo.entity.UserInfo;
import com.example.securitydemo.repository.UserInfoRepository;
import com.example.securitydemo.service.ProductService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "/welcome" , method = RequestMethod.GET)
    public String welcomeMsg(){
        return "Welcome to Products Page API";
    }



    @RequestMapping(
            value = {"/products"},
            method = {RequestMethod.POST}
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> createProduct(@RequestBody @Valid Product product) {
        this.productService.createProduct(product);
        return new ResponseEntity("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(
            value = {"/products"},
            method = {RequestMethod.GET}
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = new ArrayList(this.productService.getProduct());
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @RequestMapping(
            value = {"/products/{id}"},
            method = {RequestMethod.GET}
    )
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Object> getUniqueProduct(@PathVariable Long id) {
        return new ResponseEntity(this.productService.getUniqueProduct(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = {"/products/{id}"},
            method = {RequestMethod.DELETE}
    )
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Object> deleteProducts(@PathVariable Long id) {
        this.productService.deleteProduct(id);
        return new ResponseEntity("product is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(
            value = {"/products/{id}"},
            method = {RequestMethod.PUT}
    )
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Object> updateProducts(@PathVariable Long id, @RequestBody Product product) {
        this.productService.updateProduct(id, product);
        return new ResponseEntity("product is updated successfully", HttpStatus.OK);
    }
}
