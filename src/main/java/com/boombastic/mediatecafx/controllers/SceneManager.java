package com.boombastic.mediatecafx.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static Stage stage; // Store a static reference to the stage

    public static void setStage(Stage stage) {
        SceneManager.stage = stage;
    }

    public static void loadScene(String fxmlName) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlName));
            Parent view = loader.load();
            Scene scene = new Scene(view);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
