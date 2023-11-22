package com.microservicesalario.service;

import com.microservicesalario.models.Empleado;
import com.microservicesalario.models.Salario;

import java.util.List;

public interface SalarioService {
     List<Salario> findAll();
     Salario findById(String id, Double precioHora);

     Empleado findById(String id);



}
