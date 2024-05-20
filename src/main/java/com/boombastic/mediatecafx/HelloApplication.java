package com.boombastic.mediatecafx;

import com.boombastic.mediatecafx.entity.Usuario;
import com.boombastic.mediatecafx.repository.UsuarioRepository;
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

        Usuario usuario = new Usuario();
        usuario.setId(2);  // Ingresen una ID random mayor a 2
        usuario.setNombre("Bob");
        usuario.setApellido("Bobby");
        usuario.setContrasena("Maafaka");
        usuario.setTipoUsuario("Alumno");
        usuario.setTiempoMora(0);
        usuario.setCodigoUsuario("AM2002as");
        usuario.setCantidadMora(0);

        UsuarioRepository repository = new UsuarioRepository();
        repository.addUser(usuario);
        System.out.println(usuario.toString());
        launch();
    }
}

