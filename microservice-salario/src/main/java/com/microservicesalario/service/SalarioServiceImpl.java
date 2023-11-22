package com.microservicesalario.service;

import com.microservicesalario.models.Empleado;
import com.microservicesalario.models.Salario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalarioServiceImpl implements SalarioService{

    @Autowired
    private RestTemplate clienteRest;
    @Override
    public List<Salario> findAll() {
        List<Empleado> empleados = Arrays.asList(clienteRest.getForObject("http://localhost:8081/all", Empleado[].class));
        return empleados
                .stream()
                .map(empleado -> new Salario(empleado, 0.0))
                .collect(Collectors.toList());
    }

    @Override
    public Salario findById(String id, Double precioHora) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id);
        Empleado empleado = clienteRest.getForObject("http://localhost:8081/see/{id}", Empleado.class, pathVariables);
        return new Salario(empleado, precioHora);
    }

    @Override
    public Empleado findById(String id) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id);
        return clienteRest.getForObject("http://localhost:8081/see/{id}", Empleado.class, pathVariables);
    }


}
