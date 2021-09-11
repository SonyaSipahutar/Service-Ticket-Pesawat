package com.ProyekPasti.Proyek.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Login {
    @Id
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_password")
    private String userPassword;
    @Column(name="user_name")  // Username
    private String userName;
    @Column(name="created_at") // Mencatat waktu dibuat akun
    private Timestamp createdAt;
    @Column(name="update_at")   // Mengupdate waktu
    private Timestamp updateAt;

    public Login(){}

    public Login(String userEmail, String userPassword, String userName, Timestamp createdAt, Timestamp updateAt){
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.userName=userName;
        this.createdAt=createdAt;
        this.updateAt=updateAt;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
