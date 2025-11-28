package com.oct2025.tiendaVideojuegos.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false)
    @NotBlank(message = "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String nombre;

    // @Column(nullable = false)
    @NotBlank(message = "Este campo es obligatorio.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String apellido;

    // @Column(nullable = false, unique = true)
    @NotBlank(message = "Este campo es obligatorio.")
    @Email(message = "El email ingresado no es válido.")
    private String email;

    // @Column(nullable = false)
    @NotBlank(message = "Este campo es obligatorio.")
    @Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña necesita incluir al menos un número, una letra minúscula y una letra mayúscula.")
    private String password;

    @Transient
    private String confirmarPassword;

    // @Column(nullable = false)
    private Double coins = 200.0;

    @OneToOne
    @JoinColumn(name = "id_videojuego")
    @Transient
    private Videojuego miVideojuego;

    @ManyToMany
    @JoinTable(name = "usuarios_videojuegos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_videojuego"))
    List<Videojuego> comprados;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.miVideojuego = new Videojuego();
    }

    public List<Videojuego> getComprados() {
        return comprados;
    }

    public void setComprados(List<Videojuego> comprados) {
        this.comprados = comprados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Double getCoins() {
        return coins;
    }

    public void setCoins(Double coins) {
        this.coins = coins;
    }

    public Videojuego getMiVideojuego() {
        return miVideojuego;
    }

    public void setMiVideojuego(Videojuego miVideojuego) {
        this.miVideojuego = miVideojuego;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", password=" + password + ", coins=" + coins + "]";
    }

}
