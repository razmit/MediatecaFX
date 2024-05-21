package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Materiasdocumento;
import com.boombastic.mediatecafx.entity.Documento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DocumentoRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public DocumentoRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<Documento> findAllTP() {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("getAllTipoDocs", Documento.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Documento addTP(Documento documento) {
        em.getTransaction().begin();
        em.persist(documento);
        em.getTransaction().commit();
        return documento;
    }

    public Documento findById(int id) {
        return em.find(Documento.class, id);
    }

    public boolean updateTP(int id, String nombreTipo) {
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

    public void deleteTP(int id) {
        em.getTransaction().begin();

        Query deleteQuery = em.createNamedQuery("deleteTP");
//        deleteQuery.setParameter("documentoId", id);
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