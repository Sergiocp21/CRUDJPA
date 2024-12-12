package org.CrudEquipos.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.CrudEquipos.EntityController;

import java.util.ArrayList;
import java.util.List;

public class DAOEquipo {

    private EntityController ec;
    private EntityManager em;
    EntityTransaction tx;

    public DAOEquipo() {
        ec = EntityController.getInstance();

        em = ec.getEntityManager();
        tx = ec.getTransaction();
    }

    public List<Equipo> findAllTeams(){
        List<Equipo> equipos;

        equipos = em.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();

        return equipos;
    }

    public Equipo findTeamById(Integer id){
        return em.find(Equipo.class, id);
    }

    public void addTeam(Equipo equipo){
        tx.begin();
        em.persist(equipo);
        tx.commit();
    }

    public void updateTeam(Equipo equipo){
        tx.begin();
        em.merge(equipo);
        tx.commit();
    }

    public void deleteTeam(Equipo equipo){
        tx.begin();
        em.remove(equipo);
        tx.commit();
    }


}
