package com.lab5team1.app;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * The type Image app.
 */
public class ImageApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Loader");
        GlobalViewController.getInstance().setPrimaryStage(primaryStage);
        Scene scene = new Scene(new GlobalView().buildView(), 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}