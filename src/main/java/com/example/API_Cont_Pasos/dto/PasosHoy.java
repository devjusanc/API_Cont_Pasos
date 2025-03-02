package com.example.API_Cont_Pasos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PasosHoy {
    private BigDecimal totalPasos;
    private BigDecimal totalCalorias;

    public PasosHoy(BigDecimal totalPasos, BigDecimal totalCalorias) {
        this.totalPasos = totalPasos;
        this.totalCalorias = totalCalorias;
    }

    public BigDecimal getTotalPasos() {
        return totalPasos;
    }

    public BigDecimal getTotalCalorias() {
        return totalCalorias;
    }
}
