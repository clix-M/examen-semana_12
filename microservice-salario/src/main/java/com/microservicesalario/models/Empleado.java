package com.microservicesalario.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private String DNI;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Double horasLaboradas;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
}
