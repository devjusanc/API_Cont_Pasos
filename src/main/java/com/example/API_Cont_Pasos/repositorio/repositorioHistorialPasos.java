package com.example.API_Cont_Pasos.repositorio;
import com.example.API_Cont_Pasos.dto.PasosHoy;
import com.example.API_Cont_Pasos.dto.PasosPorFechaDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.API_Cont_Pasos.model.historialpasos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface repositorioHistorialPasos extends JpaRepository<historialpasos, Long> {
    @Query(value = "SELECT fecha, SUM(pasos) as totalPasos, SUM(pasos) * 0.04 as TotalCalorias FROM historialpasos WHERE Id_Usuario = :idUsuario GROUP BY fecha", nativeQuery = true)
    List<PasosPorFechaDTO> obtenerHistorialAgrupado(@Param("idUsuario") Long idUsuario);

    @Query(value = "SELECT SUM(pasos) as totalPasos, SUM(pasos) * 0.04 as TotalCalorias FROM historialpasos WHERE Id_Usuario = :idUsuario  AND DATE(Fecha) = CURDATE() GROUP BY fecha", nativeQuery = true)
    PasosHoy obtenerPasosHoy(@Param("idUsuario") Long idUsuario);
}