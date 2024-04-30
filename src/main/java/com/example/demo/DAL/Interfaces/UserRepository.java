package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.Tag;
import com.example.demo.Tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(@Param("userName") String userName);
}
