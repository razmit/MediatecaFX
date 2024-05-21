package com.boombastic.mediatecafx.controllers;

import com.boombastic.mediatecafx.entity.Usuario;
import com.boombastic.mediatecafx.repository.UsuarioRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LoginController {

    @FXML
    private HBox loginBox;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private Label passwordErrorLabel;
    @FXML
    private Label usernameErrorLabel;
    UsuarioRepository repository = new UsuarioRepository();

    public void initialize() {
        usernameTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validation logic for username
            if (newValue.isEmpty()) {
                System.out.printf("El nombre está vacío");
            } else {
                // Username valid, remove any error messages
            }
        });

        passwordTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            // Validation logic for password (can be more complex)
            if (newValue.isEmpty()) {
                // Show error message or disable button
            } else {
                // Password valid, remove any error messages
            }
        });
    }
    @FXML
    protected void loginValidationBtnPressed() {

        String username = usernameTxt.getText();
        String password = passwordTxt.getText();

        usernameErrorLabel.setVisible(false);
        passwordErrorLabel.setVisible(false);
//        System.out.println("User: " + username);
//        System.out.printf("Password: %s\n", password);

        if (username.isEmpty()) {usernameErrorLabel.setVisible(true); usernameErrorLabel.setTextFill(Color.RED); return;}
        if (password.isEmpty()) {passwordErrorLabel.setVisible(true); passwordErrorLabel.setTextFill(Color.RED); return;}

        if (!username.isEmpty() && !password.isEmpty()) {
            Usuario loggedUser = repository.findUserForLogin(username, password);
            if (loggedUser != null) {
                System.out.println(loggedUser.getTipoUsuario());
                if (loggedUser.getTipoUsuario().equals("Alumno")) {
                    System.out.println("Bienvenido alumno: "+loggedUser.getNombre() + " " + loggedUser.getApellido());
                    // Vista alumno
                } else if (loggedUser.getTipoUsuario().equals("Docente")) {
                    System.out.println("Bienvenido docente: "+loggedUser.getNombre() + " " + loggedUser.getApellido());
                    // Vista docente
                } else if (loggedUser.getTipoUsuario().equals("Administrador")) {
                    System.out.println("Bienvenido Admin: "+loggedUser.getNombre() + " " + loggedUser.getApellido());
                    // Vista admin
                }
            }
        }

    }
}
