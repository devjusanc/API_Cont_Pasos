package com.example.API_Cont_Pasos.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class PasosPorFechaDTO {
    private Timestamp fecha;
    private BigDecimal totalPasos;
    private BigDecimal totalCalorias;

    public PasosPorFechaDTO(Timestamp fecha,BigDecimal totalPasos, BigDecimal totalCalorias) {
        this.fecha = fecha;
        this.totalPasos = totalPasos;
        this.totalCalorias = totalCalorias;
    }
    // Getters y Setters
    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }

    public BigDecimal getTotalPasos() { return totalPasos; }
    public void setTotalPasos(BigDecimal totalPasos) { this.totalPasos = totalPasos; }

    public BigDecimal getTotalCalorias() { return totalCalorias; }
    public void setTotalCalorias(BigDecimal totalCalorias) { this.totalCalorias = totalCalorias; }

}
