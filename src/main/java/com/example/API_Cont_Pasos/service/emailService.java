package com.example.API_Cont_Pasos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService {
    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String destinatario, String nuevaClave) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject("Recuperación de Contraseña");
        mensaje.setText("Su nueva contraseña es: " + nuevaClave + "\n\nPor favor, cámbiela después de iniciar sesión.");

        mailSender.send(mensaje);
    }
}
