package com.procesos.negocio.karen.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100,nullable = false)
    //@Size(min = 1,max = 100)
    @NotBlank(message = "El campo nombre no puede estar vacio, revise los datos")
    private String nombre;
    @Column(length = 300,nullable = false)
    @NotBlank(message = "El campo apellidos no puede estar vacio, revise los datos")
    private String apellidos;
    @Column(length = 20,nullable = false,unique = true)
    @NotBlank(message = "El campo documento no puede estar vacio, revise los datos")
    private String documento;
    @Column(length = 100, nullable = true)
    private String direccion;
    @Column(nullable = true)
    private Date fechaNacimiento;
    @Column(length = 10, nullable = true)
    private String telefono;
}