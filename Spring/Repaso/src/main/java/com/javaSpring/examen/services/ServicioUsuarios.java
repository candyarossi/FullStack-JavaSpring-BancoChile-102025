package com.javaSpring.examen.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaSpring.examen.models.LoginUsuario;
import com.javaSpring.examen.models.Usuario;
import com.javaSpring.examen.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    // CRUD

    // C -> Create
    public Usuario crearUsuario(Usuario usuario) {
        String hashPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(hashPassword);
        return this.repositorioUsuarios.save(usuario);
    }

    // R -> Read
    public Usuario obtenerPorId(Long id) {
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerPorCorreo(String correo) {
        return this.repositorioUsuarios.findByCorreo(correo).orElse(null);
    }

    // U -> Update
    // D -> Delete

    // Validación de coincidencia en passwords
    public BindingResult validarPasswords(BindingResult validaciones, Usuario usuario) {
        if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
            validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "Las contraseñas no coinciden.");
        }
        return validaciones;
    }

    // Validación del email (si existe el usuario) y validación de password
    public BindingResult validarCorreoYPassword(BindingResult validaciones, LoginUsuario loginUsuario) {
        Usuario usuarioDB = this.obtenerPorCorreo(loginUsuario.getCorreo());
        if (usuarioDB == null) {
            validaciones.rejectValue("correo", "correoNoRegistrado",
                    "El correo ingresado no corresponde a ningún usuario registrado.");
        } else {
            if (!BCrypt.checkpw(loginUsuario.getPassword(), usuarioDB.getPassword())) {
                validaciones.rejectValue("password", "passwordIncorrecta", "Credenciales incorrectas.");
            }
        }
        return validaciones;
    }
}
