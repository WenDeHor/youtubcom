package com.studio.youtubcom.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;

    public Users() {
    }
    public Users(Long idUser, String password, String name) {
        this.idUser=idUser;
        this.password=password;
        this.name=name;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return idUser.equals(users.idUser) &&
                password.equals(users.password) &&
                name.equals(users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, password, name);
    }
}
