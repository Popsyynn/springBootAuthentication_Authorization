package com.example.securitydemo.controller;


import com.example.securitydemo.entity.UserInfo;
import com.example.securitydemo.repository.UserInfoRepository;
import com.example.securitydemo.service.UserInfoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserInfoServiceImplementation serviceImplementation;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping(value = "/user" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addUser(@RequestBody UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        serviceImplementation.addUser(userInfo);
        return new ResponseEntity<>("user added successfully" , HttpStatus.CREATED);
    }
}
