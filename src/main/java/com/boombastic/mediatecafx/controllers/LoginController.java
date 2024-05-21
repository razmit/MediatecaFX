package com.boombastic.mediatecafx.controllers;

import com.boombastic.mediatecafx.entity.Usuario;
import com.boombastic.mediatecafx.repository.UsuarioRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;
    UsuarioRepository repository;

    @FXML
    protected void loginValidationBtnPressed() {

        System.out.println("Yipiii");
//        String username = usernameTxt.getText();
//        String password = passwordTxt.getText();
//
//        Usuario loggedUser = repository.findUserForLogin(username, password);
//        if (loggedUser != null) {
//            System.out.println(loggedUser.getTipoUsuario());
//        }
    }
}
