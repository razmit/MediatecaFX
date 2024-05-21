package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class MateriaRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public MateriaRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<Materia> findAllMaterias() {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("getAllMaterias", Materia.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Materia addMateria(Materia mat) {
        em.getTransaction().begin();
        em.persist(mat);
        em.getTransaction().commit();
        return mat;
    }

    public Materia findById(int id) {
        return em.find(Materia.class, id);
    }

    public boolean updateMateria(int id, String nombreTipo) {
        boolean successful = false;
        em.getTransaction().begin();

        Query updateQuery  = em.createNamedQuery("updateMateria");

        updateQuery.setParameter("newNombreMateria", nombreTipo);
        updateQuery.setParameter("matId", id);

        int updatedEntities = updateQuery.executeUpdate();

        em.getTransaction().commit();
        em.clear();
        if (updatedEntities > 0) {
            successful = true;
        } else {
            System.out.println("No mat found with ID: " + id);
        }

        return successful;
    }

    public void deleteMateria(int id) {
        em.getTransaction().begin();

        Query deleteQuery = em.createNamedQuery("deleteMateria");
        deleteQuery.setParameter("matId", id);
        deleteQuery.executeUpdate();

        em.getTransaction().commit();
    }

    public Materia findMateriabyId(int id) {
        Materia md = em.createNamedQuery("getMateriaById", Materia.class)
                .setParameter("matId", id)
                .getSingleResult();
        return md;
    }

    public void deleteMateria(Materia mat) {
        em.getTransaction().begin();
        em.remove(mat);
        em.getTransaction().commit();
    }

    public void close(){
        this.em.close();
        this.emf.close();
    }
}