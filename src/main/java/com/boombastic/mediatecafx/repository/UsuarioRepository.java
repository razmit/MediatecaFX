package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class UsuarioRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public UsuarioRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<Usuario> findAllUsers() {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("getAllUsers");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Usuario addUser(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    public Usuario findById(int id) {
        return em.find(Usuario.class, id);
    }

    public boolean updateUser(int id) {
        boolean successful = false;
        em.getTransaction().begin();

        Query updateQuery  = em.createNamedQuery("updateUser");

        updateQuery.setParameter("newNombre", "Pepe");
        updateQuery.setParameter("newApellido", "Lopez");
        updateQuery.setParameter("newTipoUsuario", "Administrador");
        updateQuery.setParameter("newContrasena", "PepeLives");
        updateQuery.setParameter("newCantidadMora", 56);
        updateQuery.setParameter("newTiempoMora", 78);
        updateQuery.setParameter("newCodigo", "AM202020");
        updateQuery.setParameter("usuarioToUpdate", id);

        int updatedEntities = updateQuery.executeUpdate();

        em.getTransaction().commit();
        em.clear();
        if (updatedEntities > 0) {
            successful = true;
        } else {
            System.out.println("No hay usuario con la ID: " + id);
        }

        return successful;
    }

    public void deleteUser(int id) {
        em.getTransaction().begin();

        Query deleteQuery = em.createNamedQuery("deleteUser");
        deleteQuery.setParameter("usuarioId", id);
        deleteQuery.executeUpdate();

        em.getTransaction().commit();
    }

    public Usuario findUserbyId(int id) {
        Usuario usuario = em.createNamedQuery("getUserById", Usuario.class)
                .setParameter("userId", id)
                .getSingleResult();
        return usuario;
    }

    public Usuario findUserForLogin(String nombre, String contra) {

        Query query = em.createNamedQuery("getUserByName", Usuario.class);
        query.setParameter("nombreUser", nombre);

        Usuario usuarioLogueando = (Usuario) query.getSingleResult();

        if (usuarioLogueando != null && contra.equals(usuarioLogueando.getContrasena())) {

            return usuarioLogueando;
        } else
            return null;
    }

    public void deleteUser(Usuario usuario) {
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public void close(){
        this.em.close();
        this.emf.close();
    }
}