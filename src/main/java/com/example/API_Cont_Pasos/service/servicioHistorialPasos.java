package com.example.API_Cont_Pasos.service;

import com.example.API_Cont_Pasos.dto.PasosHoy;
import com.example.API_Cont_Pasos.dto.PasosPorFechaDTO;
import com.example.API_Cont_Pasos.model.historialpasos;
import com.example.API_Cont_Pasos.repositorio.repositorioHistorialPasos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class servicioHistorialPasos {
    @Autowired
    private repositorioHistorialPasos stepHistRep;

    public historialpasos registrarPasos(historialpasos historialPasos) {
        return stepHistRep.save(historialPasos);
    }

    public List<PasosPorFechaDTO> obtenerHistorialAgrupado(Long idUsuario) {

        return stepHistRep.obtenerHistorialAgrupado(idUsuario);
    }

    public PasosHoy obtenerPasosHoy(Long idUsuario) {
        return stepHistRep.obtenerPasosHoy(idUsuario);
    }

}
