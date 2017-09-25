package edu.usach.MIS.controller;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

public class JPAHibernateTest {

    //  Para el testing se emplea una base de datos H2.
    //  De esta forma los test son aislados y no es necesario conectarse al 
    //  servidor de mysql, porque la bd H2 está en memoria.
    
    //  Primero se crean los administradores de entidades de la base de datos.    
    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    //  Luego se especifica qué métodos se deben ejecutar antes de iniciar las
    //  pruebas, en este caso se crea el entityManagerFactory para a su vez
    //  poder crear un entityManager.    
    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        emf = Persistence.createEntityManagerFactory("mnf-pu-test");
        em = emf.createEntityManager();
        
    }
    
    //  Luego del método init, pero antes de empezar los test, se inicializa
    //  la base de datos al cargar el script "data.sql", el que introduce
    //  3 entradas en la bd y que se emplean en los test de los métodos "get".
    @Before
    public void initializeDatabase(){
        Session session = em.unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    File script = new File(getClass().getResource("/data.sql").getFile());
                    RunScript.execute(connection, new FileReader(script));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("could not initialize with script");
                }
            }
        });
    }

    //  Una vez terminados los tests, se cierra el entityManagerFactory.
    //  Además el entityManager se limpia antes de cerrarse.
    @AfterClass
    public static void tearDown(){
        em.clear();
        em.close();
        emf.close();
    }
}