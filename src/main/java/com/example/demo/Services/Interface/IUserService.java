package com.example.demo.Services.Interface;


import com.example.demo.Tables.Role;
import com.example.demo.Tables.User;
import com.example.demo.Tables.UserCredentials;

import java.util.List;

public interface IUserService {
    List<User> GetAllUsers();
    User GetUserByUserId(int userId);
    User GetUserByUserName(String userName);
    User InsertUser(User user);
    boolean RemoveUser(User user);
    User UpdateUserInfo(User user);
    List<Role> GetAllRoles();
    Role GetRoleByRoleId(long roleId);
    boolean InsertRoles(String[] roles);
    boolean RemoveRole(Role role);

    User Login(UserCredentials user);
    User Signup(UserCredentials userCredentials, User user);
}
