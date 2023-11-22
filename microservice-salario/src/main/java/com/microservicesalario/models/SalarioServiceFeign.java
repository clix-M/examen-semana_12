package com.microservicesalario.models;

import com.microservicesalario.client.EmpleadoClientRest;
import com.microservicesalario.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class SalarioServiceFeign  implements SalarioService {

    @Autowired
    private EmpleadoClientRest empleadoClientRest;
    @Override
    public List<Salario> findAll() {
        return empleadoClientRest
                .listAll()
                .stream()
                .map(empleado -> new Salario(empleado, 0.0))
                .collect(Collectors.toList());
    }

    @Override
    public Salario findById(String id, Double precioHora) {
        return new Salario(empleadoClientRest.detail(id), precioHora);
    }

    @Override
    public Empleado findById(String id) {
        return empleadoClientRest.detail(id);
    }


}
