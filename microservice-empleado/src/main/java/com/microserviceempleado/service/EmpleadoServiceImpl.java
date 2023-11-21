package com.microserviceempleado.service;

import com.microserviceempleado.entities.Empleado;
import com.microserviceempleado.pesistence.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleado{

    @Autowired
    private EmpleadoRepo empleadoRepo;
    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepo.findAll();
    }

    @Override
    public Empleado findById(String id) {
        return empleadoRepo.findById(id).orElseThrow();
    }
}
