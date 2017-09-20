package edu.usach.MIS.repository;

import org.springframework.data.repository.CrudRepository;
import edu.usach.MIS.model.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
    
}