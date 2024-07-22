package com.example.securitydemo.service;

import com.example.securitydemo.entity.UserInfo;
import com.example.securitydemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImplementation implements UserInfoService {

   @Autowired
    UserInfoRepository repository;
    @Override
    public void addUser(UserInfo userInfo) {
        repository.save(userInfo);
    }
}
