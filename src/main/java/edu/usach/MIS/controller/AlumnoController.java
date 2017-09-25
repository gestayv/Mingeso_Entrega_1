package edu.usach.MIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.usach.MIS.model.Alumno;
import edu.usach.MIS.model.AlumnoDao;


@RestController
@RequestMapping(path="/alumno")
public class AlumnoController {
    
    @Autowired
    private AlumnoDao alumnoDao;
    
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Alumno> getAllAlumnos()
    {
        return alumnoDao.getAll();
    }
    
    @GetMapping(path="/{id}")
    public @ResponseBody Alumno getAlumno(@PathVariable("id") Integer id)
    {
        long lid = id.longValue();
        return alumnoDao.getById(lid);
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
        alumnoDao.create(nuevo);
        return 1;
    }
}
