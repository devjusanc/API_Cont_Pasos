package com.example.API_Cont_Pasos.repositorio;

import com.example.API_Cont_Pasos.model.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface repositorioUsuario extends JpaRepository<usuarios, Long> {
    boolean existsByCorreo(String correo);
    Optional<usuarios> findByCorreoAndClave(String Correo, String Clave);
    Optional<usuarios> findByCorreo(String Correo);
}
