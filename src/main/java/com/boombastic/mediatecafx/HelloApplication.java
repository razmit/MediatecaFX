package com.boombastic.mediatecafx;

import com.boombastic.mediatecafx.controllers.LoginController;
import com.boombastic.mediatecafx.entity.Usuario;
import com.boombastic.mediatecafx.repository.UsuarioRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        fxmlLoader.setController(new LoginController());
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MediatecaFX");
        stage.setScene(scene);
        stage.show();
        LoginController loginController = (LoginController) fxmlLoader.getController(); // Get the controller instance from the loader
        loginController.initialize(); // Call initialize on the controller

    }

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Pepe1");
        usuario.setApellido("Lol");
        usuario.setContrasena("OhYe");
        usuario.setTipoUsuario("Docente");
        usuario.setTiempoMora(2);
        usuario.setCodigoUsuario("AM2002as");
        usuario.setCantidadMora(0);

        UsuarioRepository repository = new UsuarioRepository();
//        repository.addUser(usuario);
//        System.out.println(usuario.toString());

        List<Usuario> results = repository.findAllUsers();
        results.stream().forEach(usu -> System.out.println(usu.getNombre()));
        System.out.println("Results: "+results.toString());

//        Usuario tipoUsuario = repository.findUserbyId(6);
//        System.out.println("Tipo usuario: "+tipoUsuario.getTipoUsuario().toString());

//        boolean successful = repository.updateUser(3);
//        repository.deleteUser(4);
        launch();
    }
}

