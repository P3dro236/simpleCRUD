package com.apirest.apirest.model;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome não pode estar vazio")
    private String completeName;

    @Email(message = "Email deve ser válido")
    @NotEmpty(message = "Email não pode estar vazio")
    private String email;

    @NotEmpty(message = "Senha não pode estar vazia")
    private String password;

    // Construtor padrão sem parâmetros
    public User() {
    }

    public User(String completeName, String email, String password) {
        this.completeName = completeName;
        this.email = email;
        this.password = password;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getCompleteName() {
        return completeName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}