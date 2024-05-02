package com.example.demo.Controllers;


import com.example.demo.Services.Interface.IUserService;
import com.example.demo.Tables.Post;
import com.example.demo.Tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
