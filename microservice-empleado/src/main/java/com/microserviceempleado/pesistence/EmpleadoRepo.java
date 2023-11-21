package com.microserviceempleado.pesistence;

import com.microserviceempleado.entities.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepo extends CrudRepository<Empleado, String> {
}
