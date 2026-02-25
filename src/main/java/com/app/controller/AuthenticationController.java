package com.app.controller;

import com.app.controller.dto.AuthCreateUserRequest;
import com.app.controller.dto.AuthLoginRequest;
import com.app.controller.dto.AuthResponse;
import com.app.service.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    //**
    // form signup
    // {
    //    "username": "roger",
    //    "password": "1234",
    //    "roleRequest": {
    //        "roleListName": [
    //            "INVITED", "ADMIN", "USER"
    //        ]
    //    }
    //}
    // */
    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUserRequest) {
        return new ResponseEntity<>(this.userDetailService.createUser(authCreateUserRequest), HttpStatus.CREATED);
    }

    //**
    // form login
    // {
    //    "username": "alejandra",
    //    "password": "1234"
    //}
    // */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest) {
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }
}
