package com.example.API_Cont_Pasos.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor

public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo",nullable = false, unique = true)
    private String correo;

    @Column(name = "clave",nullable = false)
    private String clave;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "Estado",nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean estado=true;

    // Constructores
    public usuarios(){

    }

    public usuarios(String Correo, String clave) {
        this.correo = Correo;
        this.clave = clave;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return correo;
    }

    public void setUsername(String Correo) {
        this.correo = Correo;
    }

    public String getPassword() {
        return clave;
    }

    public void setPassword(String Clave) {
        this.clave = Clave;
    }
}
