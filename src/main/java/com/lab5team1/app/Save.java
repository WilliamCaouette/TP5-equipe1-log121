package com.lab5team1.app;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save extends ICommand{
    private ImageModel model;
    private Stage stage;

    public Save(ImageModel model, Stage stage) {
        this.model = model;
        this.stage = stage;
        //this.execute();
    }

    @Override
    void execute() {
        // Configure FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Serialized Object");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files", "*.ser"));

        // Show save file dialog
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileOutputStream fileOut = new FileOutputStream(file);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(model);
                System.out.println("Serialized data is saved in " + file.getAbsolutePath());
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
}
