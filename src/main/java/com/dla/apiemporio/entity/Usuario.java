package com.dla.apiemporio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long idUser;

    @Column(unique = true)
    private String emailUser;

    private String passwordUser;

    private String nameUser;

    public Usuario() {
    }

    public Usuario(String emailUser, String passwordUser, String nameUser) {
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

    public void setByObject(Usuario user) {
        this.nameUser = user.getNameUser();
        this.emailUser = user.getEmailUser();
    }

    static public boolean isValid(Usuario user) {
        return user.getNameUser() != null && user.getEmailUser() != null;
    }
}
