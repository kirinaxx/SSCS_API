package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.Tag;
import com.example.demo.Tables.User;
import com.example.demo.Tables.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.UserName = :userName")
    User findByUserName(String userName);



//    User loginUser(String )
}
