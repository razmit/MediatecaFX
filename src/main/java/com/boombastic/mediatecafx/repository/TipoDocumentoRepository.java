package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Materiasdocumento;
import com.boombastic.mediatecafx.entity.Tipodocumento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class TipoDocumentoRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public TipoDocumentoRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<Tipodocumento> findAllTP() {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("getAllTipoDocs", Tipodocumento.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Tipodocumento addTP(Tipodocumento tp) {
        em.getTransaction().begin();
        em.persist(tp);
        em.getTransaction().commit();
        return tp;
    }

    public Tipodocumento findById(int id) {
        return em.find(Tipodocumento.class, id);
    }

    public boolean updateTP(int id, String nombreTipo) {
        boolean successful = false;
        em.getTransaction().begin();

        Query updateQuery  = em.createNamedQuery("updateTP");

        updateQuery.setParameter("newNombreTipo", nombreTipo);
        updateQuery.setParameter("tpId", id);

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

    public void deleteTP(int id) {
        em.getTransaction().begin();

        Query deleteQuery = em.createNamedQuery("deleteTP");
        deleteQuery.setParameter("tpId", id);
        deleteQuery.executeUpdate();

        em.getTransaction().commit();
    }

    public Materiasdocumento findMDbyId(int id) {
        Materiasdocumento md = em.createNamedQuery("getMDById", Materiasdocumento.class)
                .setParameter("mdID", id)
                .getSingleResult();
        return md;
    }

    public void deleteUser(Materiasdocumento md) {
        em.getTransaction().begin();
        em.remove(md);
        em.getTransaction().commit();
    }

    public void close(){
        this.em.close();
        this.emf.close();
    }
}