package edu.usach.MIS.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class AlumnoDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void create(Alumno alumno)
    {
        entityManager.persist(alumno);
    }
    
    public List<Alumno> getAll()
    {
        return entityManager.createQuery("from Alumno").getResultList();
    }
    
    public Alumno getById(long id)
    {
        return entityManager.find(Alumno.class, id);
    }
    
}
