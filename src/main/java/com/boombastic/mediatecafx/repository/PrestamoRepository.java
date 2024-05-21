package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Prestamo;
import com.boombastic.mediatecafx.entity.Materiasdocumento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PrestamoRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public PrestamoRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<Prestamo> findAllPrestamos() {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("getAllInfoPrestamoAndAssociations", Prestamo.class);
        em.getTransaction().commit();
        return (List<Prestamo>) query.getResultList();
    }

    public Prestamo addDoc(Prestamo documento) {
        em.getTransaction().begin();
        em.persist(documento);
        em.getTransaction().commit();
        return documento;
    }

    public Prestamo findById(int id) {
        return em.find(Prestamo.class, id);
    }

    public boolean updateDoc(int id, String nombreTipo) {
        boolean successful = false;
        em.getTransaction().begin();

        Query updateQuery  = em.createNamedQuery("updateTP");

        updateQuery.setParameter("newNombreTipo", nombreTipo);
//        updateQuery.setParameter("documentoId", id);

        int updatedEntities = updateQuery.executeUpdate();

        em.getTransaction().commit();
        em.clear();
        if (updatedEntities > 0) {
            successful = true;
        } else {
            System.out.println("No user found with ID: " + id);
        }

        return successful;
    }

    public void deleteDoc(int id) {
        em.getTransaction().begin();

        Query deleteQuery = em.createNamedQuery("deleteTP");
//        deleteQuery.setParameter("documentoId", id);
        deleteQuery.executeUpdate();

        em.getTransaction().commit();
    }

    public Materiasdocumento findDocbyId(int id) {
        Materiasdocumento md = em.createNamedQuery("getMDById", Materiasdocumento.class)
                .setParameter("mdID", id)
                .getSingleResult();
        return md;
    }

    public void deleteDoc(Prestamo doc) {
        em.getTransaction().begin();
        em.remove(doc);
        em.getTransaction().commit();
    }

    public void close(){
        this.em.close();
        this.emf.close();
    }
}