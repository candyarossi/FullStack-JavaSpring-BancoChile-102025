package com.oct2025.tiendaVideojuegos.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.oct2025.tiendaVideojuegos.models.LoginUsuario;
import com.oct2025.tiendaVideojuegos.models.Usuario;
import com.oct2025.tiendaVideojuegos.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    public Usuario obtenerUsuarioPorId(Long id) {
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        return this.repositorioUsuarios.findByEmail(email).orElse(null);
    }

    public Usuario crearUsuario(Usuario usuario) {
        String newPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(newPassword);
        return this.repositorioUsuarios.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return this.repositorioUsuarios.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        this.repositorioUsuarios.deleteById(id);
    }

    public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
        if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
            validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "Las contraseñas no coinciden.");
        }
        return validaciones;
    }

    public BindingResult validarLogin(BindingResult validaciones, LoginUsuario loginUsuario) {
        Usuario usuarioDB = this.obtenerUsuarioPorEmail(loginUsuario.getEmail());
        if (!BCrypt.checkpw(loginUsuario.getPassword(), usuarioDB.getPassword())) {
            validaciones.rejectValue("password", "passwordIncorrecta", "Contraseña incorrecta.");
        }
        return validaciones;
    }
}
