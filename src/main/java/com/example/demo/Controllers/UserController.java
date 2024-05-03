package com.example.demo.Controllers;


import com.example.demo.Services.Interface.IUserService;
import com.example.demo.Tables.Post;
import com.example.demo.Tables.User;
import com.example.demo.Tables.UserCredentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
    private final IUserService _userService;
    @Autowired
    public UserController(IUserService _userService) {
        this._userService = _userService;
    }

    @GetMapping(value="allusers")
    public List<User> getAllUser() {
        return _userService.GetAllUsers();
    }


    @PostMapping(value="login")
    public User login(@RequestBody String json) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            UserCredentials user = mapper.readValue(json, UserCredentials.class);
            return _userService.Login(user);
        } catch (Exception e) {
            return null;
        }
    }
    @PostMapping(value="signup")
    public User SignUp(@RequestBody String json) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            UserCredentials userCredentials = mapper.readValue(json, UserCredentials.class);
            User user = mapper.readValue(json, User.class);
            return _userService.Signup(userCredentials, user);
        } catch (Exception e) {
            return null;
        }
    }
}
