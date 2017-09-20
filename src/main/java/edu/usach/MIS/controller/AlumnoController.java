package edu.usach.MIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.usach.MIS.model.Alumno;
import edu.usach.MIS.repository.AlumnoRepository;


@RestController
@RequestMapping(path="/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Alumno> getAllAlumnos()
    {
        return alumnoRepository.findAll();
    }
    
    @GetMapping(path="/{id}")
    public @ResponseBody Alumno getAlumno(@PathVariable("id") Integer id)
    {
        long lid = id.longValue();
        return alumnoRepository.findOne(lid);
    }
    
    @RequestMapping(path="/new", method= RequestMethod.POST)
    public Integer createAlumno(@RequestBody Alumno alumno)
    {
        Alumno nuevo = new Alumno();
        nuevo.setNombre(alumno.getNombre());
        nuevo.setPassword(alumno.getPassword());
        nuevo.setCarrera(alumno.getCarrera());
        nuevo.setEmail(alumno.getEmail());
        nuevo.setIngreso(alumno.getIngreso());
        nuevo.setRut(alumno.getRut());
        alumnoRepository.save(nuevo);
        return 1;
    }
}
