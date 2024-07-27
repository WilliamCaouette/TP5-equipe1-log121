package com.lab5team1.app;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.html.HTMLObjectElement;

import java.io.File;

public class ToolBar {
    private Stage primaryStage;

    public ToolBar(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public HBox buildToolBar(){
        HBox toolbar = new HBox();
        Button loadButton = new Button("Load Image");
        loadButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
        });
        toolbar.getChildren().add(loadButton);

        Button undoButton = new Button("Undo");
        undoButton.setOnAction(e -> {

        });

        toolbar.getChildren().add(undoButton);

        Button saveButton = new Button("Save");
        loadButton.setOnAction(e -> {

        });
        toolbar.getChildren().add(saveButton);
        return toolbar;
    }
}
