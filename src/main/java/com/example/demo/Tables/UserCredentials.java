package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
@Table(name="UserCredentials")
public class UserCredentials {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name="UserId", nullable = false)
    private String UserId;
    @Column(name="UserLogin", nullable = true)
    private String UserLogin;
    @Column(name="UserPassword", nullable = true)
    private String UserPassword;
    @Column(name="UserHash", nullable = true)
    private String UserHash;
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String userLogin) {
        UserLogin = userLogin;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserHash() {
        return UserHash;
    }

    public void setUserHash(String userHash) {
        UserHash = userHash;
    }

    public UserCredentials(Integer id, String userId, String userLogin, String userPassword, String userHash) {
        Id = id;
        UserId = userId;
        UserLogin = userLogin;
        UserPassword = userPassword;
        UserHash = userHash;
    }

}
