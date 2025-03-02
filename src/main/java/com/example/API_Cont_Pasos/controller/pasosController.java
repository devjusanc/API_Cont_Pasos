package com.example.API_Cont_Pasos.controller;

import com.example.API_Cont_Pasos.dto.PasosHoy;
import com.example.API_Cont_Pasos.dto.PasosPorFechaDTO;
import com.example.API_Cont_Pasos.model.historialpasos;
import com.example.API_Cont_Pasos.service.servicioHistorialPasos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/historialpasos")
public class pasosController {
    @Autowired
    private servicioHistorialPasos srvStepHist;

    @PostMapping("/registrar")
    public ResponseEntity<Map<String, Object>> registrarPasos(@RequestBody historialpasos historialPasos) {
        historialPasos.setFecha(LocalDateTime.now()); // Asigna la fecha actual
        historialpasos nuevoRegistro = srvStepHist.registrarPasos(historialPasos);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Registro exitoso");

        return ResponseEntity.ok(respuesta);
    }
    @GetMapping("/historico/{idUsuario}")
    public ResponseEntity<List<PasosPorFechaDTO>> obtenerHistorialAgrupado(@PathVariable Long idUsuario) {
        List<PasosPorFechaDTO> historial = srvStepHist.obtenerHistorialAgrupado(idUsuario);
        return ResponseEntity.ok(historial);
    }
    @GetMapping("/pasoHoy/{idUsuario}")
    public ResponseEntity<PasosHoy> obtenerPasosHoy(@PathVariable Long idUsuario) {
        PasosHoy result = srvStepHist.obtenerPasosHoy(idUsuario);

        return ResponseEntity.ok(result);
    }
}
