package com.microserviceempleado.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empleado {
    @Id
    private String DNI;
    private String nombre;
    @Column(name = "ap_pat")
    private String apellidoPaterno;
    @Column(name = "ap_mat")
    private String apellidoMaterno;
    @Column(name = "horas_lab")
    private Double horasLaboradas;
    @Column(name = "fecha_nac")

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
}
