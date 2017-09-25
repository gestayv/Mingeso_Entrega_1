package edu.usach.MIS.controller;

import edu.usach.MIS.model.Alumno;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlumnoControllerTest extends JPAHibernateTest{

    @Test
    public void testCreateAlumno() {
        em.getTransaction().begin();
        Alumno nuevo = new Alumno();
        nuevo.setNombre("Alumno 1");
        nuevo.setPassword("pass123");
        nuevo.setCarrera("Carrera");
        nuevo.setEmail("mail@mail.com");
        nuevo.setIngreso(2013);
        nuevo.setRut("123456");
        em.persist(nuevo);
        em.getTransaction().commit();

        List<Alumno> alumnos = em.createQuery("from Alumno").getResultList();
        System.out.println("==========="+alumnos.size()+"===========");
        System.out.println(alumnos.get(alumnos.size()-1).getNombre());
        assertNotNull(alumnos);
    }
    
    @Test
    public void testGetAllAlumnos() {
        List<Alumno> alumnos = em.createQuery("from Alumno").getResultList();
        assertNotNull(alumnos);
    }

    @Test
    public void testGetAlumno() {
        Integer test = 1;
        Alumno alumno = em.find(Alumno.class, test.longValue());
        assertNotNull(alumno);
    }
        
}
