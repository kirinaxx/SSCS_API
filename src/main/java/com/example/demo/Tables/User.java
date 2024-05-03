package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
@Table(name="UserInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name="UserName", nullable = true)
    private String userName;
    @Column(name="FirstName", nullable = true)
    private String FirstName;
    @Column(name="LastName", nullable = true)
    private String LastName;
    @Column(name="SchoolStatus", nullable = true)
    private String SchoolStatus;
    @Column(name="RoleID", nullable = true)
    private Long RoleID;
    @Column(name="AutoTranslate", nullable = true)
    private Boolean AutoTranslate;
    @Column(name="Notification", nullable = true)
    private Boolean Notifications;

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

    public Boolean isAutoTranslate() {
        return AutoTranslate;
    }

    public void setAutoTranslate(boolean autoTranslate) {
        AutoTranslate = autoTranslate;
    }

    public Boolean isNotifications() {
        return Notifications;
    }

    public void setNotifications(boolean notifications) {
        Notifications = notifications;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.userName = userName;
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    @Override
    public String toString()
    {
        return "User ID: " + this.Id + "\nUser Name: " + this.userName + "\n";
    }

}
