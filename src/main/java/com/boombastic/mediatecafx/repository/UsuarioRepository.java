package com.boombastic.mediatecafx.repository;

import com.boombastic.mediatecafx.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.usertype.UserType;

import java.util.List;

public class UsuarioRepository {

    private EntityManager em;
    private EntityManagerFactory emf;

    public UsuarioRepository() {
        emf = Persistence.createEntityManagerFactory("default");
        this.em = this.emf.createEntityManager();
    }

    public List<String> findAllUsers() {
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT u FROM Usuario u");
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

    public Usuario updateUser(Usuario usuario) {
        Usuario userToChange = em.find(Usuario.class, usuario.getId());
        em.getTransaction().begin();

        userToChange.setNombre(usuario.getNombre());
        userToChange.setApellido(usuario.getApellido());
        userToChange.setContrasena(usuario.getContrasena());
        userToChange.setTipoUsuario(usuario.getTipoUsuario());
        userToChange.setCodigoUsuario(usuario.getCodigoUsuario());
        userToChange.setCantidadMora(usuario.getCantidadMora());
        userToChange.setTiempoMora(userToChange.getTiempoMora());

        em.getTransaction().commit();
        return userToChange;
    }

    public Usuario getUserTypeById(int id) {
        Usuario usuario = em.createNamedQuery("getUserById", Usuario.class)
                .setParameter("userId", id)
                .getSingleResult();
        return usuario;
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