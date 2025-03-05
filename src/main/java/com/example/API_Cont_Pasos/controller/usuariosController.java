package com.example.API_Cont_Pasos.controller;

import com.example.API_Cont_Pasos.dto.ActualizarCalveDTO;
import com.example.API_Cont_Pasos.model.usuarios;
import com.example.API_Cont_Pasos.service.servicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class usuariosController {
    @Autowired
    private servicioUsuarios usrServ;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> autenticarUsuario(@RequestBody usuarios usuario) {
        Optional<usuarios> usuarioEncontrado = usrServ.autenticarUsuario(usuario.getUsername(), usuario.getPassword());

        Map<String, Object> respuesta = new HashMap<>();

        if (usuarioEncontrado.isPresent()) {
            usuarios usuarioAutenticado = usuarioEncontrado.get();
            respuesta.put("mensaje", "Usuario autenticado con éxito");
            respuesta.put("idUsuario", usuarioAutenticado.getId());
            return ResponseEntity.ok(respuesta);
            //return ResponseEntity.ok("Usuario autenticado con éxito");
        } else {
            respuesta.put("mensaje", "Credenciales incorrectas");
            respuesta.put("idUsuario", null);
            return ResponseEntity.ok(respuesta);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody usuarios usuario) {
        try {
            String resultado = usrServ.registrarUsuario(usuario);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar usuario: " + e.getMessage());
        }
    }

    @PostMapping("/recuperarClave")
    public String recuperarClave(@RequestBody usuarios usuario) {
        return usrServ.recuperarClave(usuario.getCorreo());
    }

    @PostMapping("/actualizarClave")
    public String actualizarClave(@RequestBody ActualizarCalveDTO CambioClave) {
        return usrServ.actualizarClave(CambioClave.getCorreo(), CambioClave.getClaveActual(), CambioClave.getNuevaClave());
    }




}
