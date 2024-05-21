package com.boombastic.mediatecafx;

import com.boombastic.mediatecafx.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction  = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            Usuario usuario = new Usuario();
            usuario.setId(1);
            usuario.setNombre("Jimmy");
            usuario.setApellido("Space");
            usuario.setTipoUsuario("Administrador");
            usuario.setContraseña("Pepe");
            entityManager.persist(usuario);

            entityTransaction.commit();
        } finally {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }

            entityManager.close();
            entityManagerFactory.close();
        }
        launch();
    }
}