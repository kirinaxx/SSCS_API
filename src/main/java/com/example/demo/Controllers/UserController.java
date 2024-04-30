package com.example.demo.Controllers;


import com.example.demo.Services.Interface.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService _userService;

    public UserController(IUserService _userService) {
        this._userService = _userService;
    }



}
