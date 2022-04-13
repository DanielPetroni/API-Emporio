package com.dla.apiemporio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long idUser;

    private String emailUser;

    private String passwordUser;

    private String nameUser;

    public User(String emailUser, String passwordUser, String nameUser) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.nameUser = nameUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
