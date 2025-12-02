package com.javaSpring.examen.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor proporciona tu nombre.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String nombre;

    @NotBlank(message = "Por favor proporciona tu apellido.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String apellido;

    @Column(unique = true)
    @NotBlank(message = "Por favor proporciona tu correo.")
    @Email(message = "Por favor ingresa un correo válido.")
    private String correo;

    @NotBlank(message = "Por favor proporciona un contraseña.")
    @Size(min = 8, message = "Debe contener al menos 8 caracteres.")
    private String password;

    @Transient
    private String confirmarPassword;

    @OneToMany(mappedBy = "creador")
    private List<Frase> frasesCreadas;

    @ManyToMany
    @JoinTable(name = "favoritos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_frase"))
    private List<Frase> frasesFavoritas;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String correo, String password, String confirmarPassword,
            List<Frase> frasesCreadas, List<Frase> frasesFavoritas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.confirmarPassword = confirmarPassword;
        this.frasesCreadas = frasesCreadas;
        this.frasesFavoritas = frasesFavoritas;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    public List<Frase> getFrasesCreadas() {
        return frasesCreadas;
    }

    public void setFrasesCreadas(List<Frase> frasesCreadas) {
        this.frasesCreadas = frasesCreadas;
    }

    public List<Frase> getFrasesFavoritas() {
        return frasesFavoritas;
    }

    public void setFrasesFavoritas(List<Frase> frasesFavoritas) {
        this.frasesFavoritas = frasesFavoritas;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", password=" + password
                + ", confirmarPassword=" + confirmarPassword + "]";
    }
}
