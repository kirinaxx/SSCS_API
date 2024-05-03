package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
@Table(name="UserCredentials")
public class UserCredentials {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="UserId", nullable = false)
    private Integer userId;
    @Column(name="UserLogin", nullable = true)
    private String userLogin;
    @Column(name="UserPassword", nullable = true)
    private String userPassword;
    @Column(name="UserHash", nullable = true)
    private String userHash;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public UserCredentials()
    { }
    public UserCredentials(Integer id, Integer userId, String userLogin, String userPassword, String userHash) {
        this.id = id;
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userHash = userHash;
    }

}
