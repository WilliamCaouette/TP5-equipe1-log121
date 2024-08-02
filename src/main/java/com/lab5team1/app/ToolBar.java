package com.lab5team1.app;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.html.HTMLObjectElement;

import java.io.File;

/**
 * The type Tool bar.
 */
public class ToolBar {
    private Stage primaryStage;

    /**
     * Instantiates a new Tool bar.
     */
    public ToolBar(){

    }

    /**
     * Build tool bar h box.
     *
     * @return the h box
     */
    public HBox buildToolBar(){
        HBox toolbar = new HBox();
        Button loadButton = new Button("Load Image");
        loadButton.setOnAction(e -> {
            GlobalViewController.getInstance().load();
        });
        toolbar.getChildren().add(loadButton);

        Button undoButton = new Button("Undo");
        undoButton.setOnAction(e -> {
            GlobalViewController.getInstance().undoEvent();
        });

        Button redoButton = new Button("Redo");
        redoButton.setOnAction(e -> {
            GlobalViewController.getInstance().redoEvent();
        });

        toolbar.getChildren().add(undoButton);

        toolbar.getChildren().add(redoButton);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            GlobalViewController.getInstance().save(GlobalViewController.getInstance().getModel());
        });
        toolbar.getChildren().add(saveButton);

        Button openButton = new Button("Open File");
        openButton.setOnAction(e -> {
            GlobalViewController.getInstance().openFile();
        });
        toolbar.getChildren().add(openButton);

        return toolbar;
    }
}
