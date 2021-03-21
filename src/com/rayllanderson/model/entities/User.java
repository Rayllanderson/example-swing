package com.rayllanderson.model.entities;

import com.rayllanderson.model.entities.enums.Perfil;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cpf;
    private String name;
    private String email;
    private Date birthdate;
    private Perfil perfil;
    private boolean active;


    public User() {
    }

    public User(String cpf, String name, String email, Date birthdate, Perfil perfil, boolean active) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.perfil = perfil;
        this.active = active;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return cpf.equals(user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" + "cpf=" + cpf + ", name='" + name + '\'' + ", email='" + email + '\'' + ", birthdate=" + birthdate + ", " +
                "perfil=" + perfil + ", active=" + active + '}';
    }
}
