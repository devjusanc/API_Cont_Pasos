package com.example.API_Cont_Pasos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "historialpasos")
public class historialpasos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="IdUsuario")
    private Long idUsuario;

    @Column(nullable = false,name="Fecha")
    private LocalDateTime fecha;

    @Column(nullable = false,name="Pasos")
    private int pasos;

    // Constructor vacío (obligatorio para JPA)
    public historialpasos() {}

    // Constructor con parámetros
    public historialpasos(Long idUsuario, LocalDateTime fecha, int pasos) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.pasos = pasos;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
}

