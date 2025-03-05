package com.example.API_Cont_Pasos.service;

import com.example.API_Cont_Pasos.model.usuarios;
import com.example.API_Cont_Pasos.repositorio.repositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Optional;

@Service
public class servicioUsuarios {
    @Autowired
    private repositorioUsuario usrRep;
    @Autowired
    private emailService mailserv;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Optional<usuarios> autenticarUsuario(String Correo, String Clave) {
        Optional<usuarios> usuarioOpt = usrRep.findByCorreo(Correo);
        if (usuarioOpt.isPresent()) {
            usuarios usuario = usuarioOpt.get();

            //Comparar la clave ingresada con la clave en BD
            if (encoder.matches(Clave, usuario.getClave())) {
                return Optional.of(usuario); // Login exitoso
            }
        }

        return Optional.empty(); // Credenciales incorrectas

    }

    public String registrarUsuario(usuarios usuario) {
        Optional<usuarios> buscarUsuario=usrRep.findByCorreo(usuario.getCorreo());
        if (buscarUsuario.isPresent()) {
            return "El correo ya está registrado.";
        }

        // Encriptar clave antes de guardar
        usuario.setClave(encoder.encode(usuario.getClave()));

        usrRep.save(usuario);
        return "Usuario registrado exitosamente.";
    }

    public String actualizarClave(String correo, String claveActual, String nuevaClave) {
        Optional<usuarios> usuarioOpt = usrRep.findByCorreo(correo);

        if (usuarioOpt.isPresent()) {
            usuarios usuario = usuarioOpt.get();

            // Verificar si la clave actual es correcta
            if (!encoder.matches(claveActual, usuario.getClave())) {
                return "La contraseña actual es incorrecta.";
            }

            // Encriptar la nueva clave y actualizar
            usuario.setClave(encoder.encode(nuevaClave));
            usrRep.save(usuario);
            return "Contraseña actualizada exitosamente.";
        }

        return "El correo no está registrado.";
    }


    public String recuperarClave(String correo) {
        Optional<usuarios> usuarioOpt = usrRep.findByCorreo(correo);

        if (usuarioOpt.isPresent()) {
            usuarios usuario = usuarioOpt.get();
            String nuevaClave = generarClaveAleatoria(); // Generar clave nueva
            usuario.setClave(encoder.encode(nuevaClave)); // Guardar clave encriptada
            usrRep.save(usuario); // Actualizar en BD

            mailserv.enviarCorreo(correo, nuevaClave); // Enviar email
            return "Se ha enviado una nueva contraseña a su correo.";
        }

        return "El correo no está registrado.";
    }

    private String generarClaveAleatoria() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder clave = new StringBuilder();

        for (int i = 0; i < 8; i++) { // Genera una clave de 8 caracteres
            clave.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        return clave.toString();
    }
}
