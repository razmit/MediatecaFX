package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Materiasdocumento;
import com.boombastic.mediatecafx.entity.Materiasdocumento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class MateriasDocumentoRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public MateriasDocumentoRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<Materiasdocumento> findAllMD() {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("getAllMDs", Materiasdocumento.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Materiasdocumento addMD(Materiasdocumento md) {
        em.getTransaction().begin();
        em.persist(md);
        em.getTransaction().commit();
        return md;
    }

    public Materiasdocumento findById(int id) {
        return em.find(Materiasdocumento.class, id);
    }

    public boolean updateMD(int id, int idDocumento, int idMateria) {
        boolean successful = false;
        em.getTransaction().begin();

        Query updateQuery  = em.createNamedQuery("updateMD");

        updateQuery.setParameter("newIdDocumento", idDocumento);
        updateQuery.setParameter("newIdMateria", idMateria);
        updateQuery.setParameter("mdToUpdate", id);

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

    public void deleteMD(int id) {
        em.getTransaction().begin();

        Query deleteQuery = em.createNamedQuery("deleteMD");
        deleteQuery.setParameter("mdId", id);
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