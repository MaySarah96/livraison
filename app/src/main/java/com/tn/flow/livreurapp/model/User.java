package com.tn.flow.livreurapp.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    Integer userId;

    @SerializedName("userName")
    String userName;

    @SerializedName("encrytedPassword")
    String encrytedPassword;

    @SerializedName("nom")
    String nom;

    @SerializedName("prenom")
    String prenom;

    @SerializedName("cin")
     Integer cin;

    @SerializedName("num_tel")
     Integer numTel;



    public User(Integer userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public Integer getNumTel() {
        return numTel;
    }

    public void setNumTel(Integer numTel) {
        this.numTel = numTel;
    }
}
