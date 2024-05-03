package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.User;
import com.example.demo.Tables.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer> {
}
