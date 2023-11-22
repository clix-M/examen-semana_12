package com.microservicesalario.controller;

import com.microservicesalario.models.Empleado;
import com.microservicesalario.models.Salario;
import com.microservicesalario.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @GetMapping("/all")
    public List<Salario> listAll(){
        return salarioService.findAll();
    }


   @GetMapping("/see/{id}/{precioHora}")
    public Salario detail(@PathVariable String id, @PathVariable Double precioHora){
    return salarioService.findById(id, precioHora);
}

    @GetMapping("/see/{id}/edad")
    public Map<String, Object> edad(@PathVariable String id){
      /*  Optional<Empleado> empleadoOp = Optional.ofNullable(salarioService.findById(id));
        if(empleadoOp.isPresent()){
            Empleado empleado = empleadoOp.get();
           // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            LocalDate fechaNacimiento = LocalDate.parse(empleado.getFechaNacimiento().toString(), formatter);
            return Year.now().getValue() - fechaNacimiento.getYear();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }

       */
        Optional<Empleado> empleadoOp = Optional.ofNullable(salarioService.findById(id));
        if(empleadoOp.isPresent()){
            Empleado empleado = empleadoOp.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            LocalDate fechaNacimiento = LocalDate.parse(empleado.getFechaNacimiento().toString(), formatter);
            int edad = Year.now().getValue() - fechaNacimiento.getYear();

            Map<String, Object> response = new HashMap<>();
            response.put("nombre", empleado.getNombre());
            response.put("edad", edad);
            return response;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }

    }





}
