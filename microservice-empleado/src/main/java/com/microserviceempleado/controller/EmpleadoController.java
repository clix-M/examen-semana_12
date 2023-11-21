package com.microserviceempleado.controller;

import com.microserviceempleado.entities.Empleado;
import com.microserviceempleado.service.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private IEmpleado empleadoService;

    @GetMapping("/all")
    public List<Empleado> findAll() {
        return empleadoService.findAll();
    }

    @GetMapping("/see/{id}")
    public Empleado findById(@PathVariable String id) {
        return empleadoService.findById(id);
    }
}
