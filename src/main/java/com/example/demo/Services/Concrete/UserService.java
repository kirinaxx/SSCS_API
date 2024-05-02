package com.example.demo.Services.Concrete;

import com.example.demo.DAL.Interfaces.RoleRepository;
import com.example.demo.DAL.Interfaces.UserRepository;
import com.example.demo.Services.Interface.IUserService;
import com.example.demo.Tables.Role;
import com.example.demo.Tables.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final com.example.demo.DAL.Interfaces.UserRepository _userRepository;
    private final RoleRepository _roleRepository;

    public UserService(UserRepository _userRepository, RoleRepository roleRepository) {
        this._userRepository = _userRepository;
        _roleRepository = roleRepository;
    }

    @Override
    public List<User> GetAllUsers() {
        return _userRepository.findAll();
    }

    @Override
    public User GetUserByUserId(int userId) {
        return _userRepository.findById(userId).orElse(null);
    }

    @Override
    public User GetUserByUserName(String userName) {
        return _userRepository.findByUserName(userName);
    }

    @Override
    public User InsertUser(User user) {
        return _userRepository.save(user);
    }

    @Override
    public boolean RemoveUser(User user) {
        try{
            _userRepository.delete(user);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public User UpdateUserInfo(User user) {
        return _userRepository.save(user);
    }

    @Override
    public List<Role> GetAllRoles() {
        return _roleRepository.findAll();
    }

    @Override
    public Role GetRoleByRoleId(long roleId) {
        return _roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public boolean InsertRoles(String[] roles) {
        List<Role> rolesList = new ArrayList<Role>();
        for(int i=0;i<roles.length;i++)
        {
            Role role = new Role(roles[i]);
            rolesList.add(role);
        }
        try{
            _roleRepository.saveAll(rolesList);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public boolean RemoveRole(Role role) {
        try{
            _roleRepository.delete(role);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}
