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
import java.util.List;

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
        usuario.setNombre("Jimmy");
        usuario.setApellido("Lol");
        usuario.setContrasena("OhYe");
        usuario.setTipoUsuario("Docente");
        usuario.setTiempoMora(2);
        usuario.setCodigoUsuario("AM2002as");
        usuario.setCantidadMora(0);

        UsuarioRepository repository = new UsuarioRepository();
        repository.addUser(usuario);
        System.out.println(usuario.toString());

        List<String> results = repository.findAllUsers();
        System.out.println("Results: "+results.toString());

        Usuario tipoUsuario = repository.getUserTypeById(1);
        System.out.println("Tipo usuario: "+tipoUsuario.getTipoUsuario().toString());
        launch();
    }
}

