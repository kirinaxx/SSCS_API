package com.example.demo.Tables;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String UserName;
    private String FirstName;
    private String LastName;
    private String SchoolStatus;
    private Long RoleID;
    private boolean AutoTranslate;
    private boolean Notifications;

    public String getSchoolStatus() {
        return SchoolStatus;
    }

    public void setSchoolStatus(String schoolStatus) {
        SchoolStatus = schoolStatus;
    }

    public Long getRoleID() {
        return RoleID;
    }

    public void setRoleID(Long roleID) {
        RoleID = roleID;
    }

    public boolean isAutoTranslate() {
        return AutoTranslate;
    }

    public void setAutoTranslate(boolean autoTranslate) {
        AutoTranslate = autoTranslate;
    }

    public boolean isNotifications() {
        return Notifications;
    }

    public void setNotifications(boolean notifications) {
        Notifications = notifications;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public User() {
    }

    public User(String userName, String firstName, String lastName) {
        this.UserName = userName;
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "User ID: " + this.id + "\nUser Name: " + this.UserName + "\n";
    }

}
