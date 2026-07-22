package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.AuthenticationResponse;
import com.cognizant.spring_learn.security.JwtUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String header) {

        String base64Credentials = header.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(base64Credentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        String username = credentials.split(":")[0];

        String token = jwtUtil.generateToken(username);

        return new AuthenticationResponse(token);
    }
} 