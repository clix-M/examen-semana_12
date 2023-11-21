package com.microserviceempleado.service;

import com.microserviceempleado.entities.Empleado;

import java.util.List;

public interface IEmpleado {

    public List<Empleado> findAll();
    public Empleado findById(String id);
}
