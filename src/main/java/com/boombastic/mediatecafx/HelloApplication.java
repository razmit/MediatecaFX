package com.boombastic.mediatecafx;

import com.boombastic.mediatecafx.controllers.LoginController;
import com.boombastic.mediatecafx.entity.*;
import com.boombastic.mediatecafx.repository.DocumentoRepository;
import com.boombastic.mediatecafx.repository.PrestamoRepository;
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

        // Add user
        Usuario usuario = new Usuario();
        usuario.setNombre("Pepe1");
        usuario.setApellido("Lol");
        usuario.setContrasena("OhYe");
        usuario.setTipoUsuario("Docente");
        usuario.setTiempoMora(2);
        usuario.setCodigoUsuario("AM2002as");
        usuario.setCantidadMora(0);

        // User repository
        UsuarioRepository repository = new UsuarioRepository();
        DocumentoRepository documentoRepository = new DocumentoRepository();

        Usuario newUser = repository.addUser(usuario);

        // Docs repository
//        List<Documento> listaDocs = documentoRepository.findAllDocs();
////        listaDocs.stream().forEach(documento -> System.out.println(documento.getTitulo()));
//        for (Documento documento : listaDocs) {
//            System.out.println("Titulo doc: " + documento.getTitulo());
//            Tipodocumento tipodocumento = documento.getIdTipoDocumento();
//            System.out.println("TipoDocumento: " + tipodocumento.getNombreTipo());
//
//            List<Cdaudio> cdaudioList = documento.getCdaudioList();
//            cdaudioList.stream().forEach(cdaudio -> System.out.println("CD audio: "  + cdaudio.getArtista()));
//        }


//        // Prestamo repo
//        PrestamoRepository prestamoRepository = new PrestamoRepository();
//
//        List<Prestamo> prestamoList = prestamoRepository.findAllPrestamos();
//        for (Prestamo prestamo : prestamoList) {
//            System.out.println("Estado prestamo: " + prestamo.getEstado());
//            Documento doc = prestamo.getIdDocumento();
//            System.out.println("El documento es: " + doc.getTitulo());
//        }
//        repository.addUser(usuario);
//        System.out.println(usuario.toString());

        List<Usuario> results = repository.findAllUsers();
        results.stream().forEach(usu -> System.out.println(usu.getNombre()));
        System.out.println("Results: "+results.toString());

        Usuario tipoUsuario = repository.findUserbyId(2);
        System.out.println("Tipo usuario: "+tipoUsuario.getTipoUsuario().toString());

//        boolean successful = repository.updateUser(3);
//        repository.deleteUser(4);
        launch();
    }
}

