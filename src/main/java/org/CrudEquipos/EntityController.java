package org.CrudEquipos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EntityController {

    private static EntityController instancia;

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    private EntityController() {
        emf = Persistence.createEntityManagerFactory("unidad-empresa");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    public static EntityController getInstance(){
        if(instancia == null){
            instancia = new EntityController();
        }
        return instancia;
    }

    public EntityManager getEntityManager(){
        return em;
    }

    public EntityTransaction getTransaction(){
        return tx;
    }

    public void cerrar() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

}
