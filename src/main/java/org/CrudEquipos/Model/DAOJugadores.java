package org.CrudEquipos.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.CrudEquipos.EntityController;

import java.util.ArrayList;
import java.util.List;

public class DAOJugadores {

    private EntityController ec;
    private EntityManager em;
    EntityTransaction tx;

    public DAOJugadores() {
        ec = EntityController.getInstance();

        em = ec.getEntityManager();
        tx = ec.getTransaction();
    }

    public List<Jugador> getAllPlayers(){
        List<Jugador> jugadores;

        jugadores = em.createQuery("SELECT j FROM Jugador j", Jugador.class).getResultList();

        return jugadores;
    }

    public Jugador getPlayerById(Integer id){
        return em.find(Jugador.class, id);
    }

    public void addPlayer(Jugador jugador){
        tx.begin();
        em.persist(jugador);
        tx.commit();
    }

    public void updatePlayer(Jugador jugador){
        tx.begin();
        em.merge(jugador);
        tx.commit();
    }

    public void deletePlayer(Jugador jugador){
        tx.begin();
        em.remove(jugador);
        tx.commit();
    }

}
