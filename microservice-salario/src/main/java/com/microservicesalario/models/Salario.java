package com.microservicesalario.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salario {
    Empleado empleado;
    private Double precioHora;

    public Double getSalario(){
        return this.precioHora * this.empleado.getHorasLaboradas();
    }


}
