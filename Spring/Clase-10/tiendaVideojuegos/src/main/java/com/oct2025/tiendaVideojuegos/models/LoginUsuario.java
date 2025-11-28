package com.oct2025.tiendaVideojuegos.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginUsuario {

    @NotBlank(message = "Este campo es obligatorio.")
    @Email(message = "El email ingresado no es válido.")
    private String email;

    @NotBlank(message = "Este campo es obligatorio.")
    @Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña necesita incluir al menos un número, una letra minúscula y una letra mayúscula.")
    private String password;

    public LoginUsuario() {
    }

    public LoginUsuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUsuario [email=" + email + ", password=" + password + "]";
    }
}
