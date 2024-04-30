package com.example.demo.DAL.Interfaces;

import com.example.demo.Tables.Role;
import com.example.demo.Tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
