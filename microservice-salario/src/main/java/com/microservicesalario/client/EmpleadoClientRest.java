package com.microservicesalario.client;

import com.microservicesalario.models.Empleado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-empleado", url = "localhost:8081")
public interface EmpleadoClientRest {
    @GetMapping("/all")
    public List<Empleado> listAll();

    @GetMapping("/see/{id}")
    public Empleado detail(@PathVariable String id);
}
