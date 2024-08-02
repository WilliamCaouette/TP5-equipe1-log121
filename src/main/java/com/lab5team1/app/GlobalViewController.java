package com.lab5team1.app;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class GlobalViewController {
    private static GlobalViewController instance;

    private Tab staticTab = new StaticTab();
    private OperationTab OperationTab1 = new OperationTab();
    private OperationTab OperationTab2 = new OperationTab();
    private ToolBar toolBar = new ToolBar();
    private Stage primaryStage;

    Position position = new Position(0d, 0d, 1.0, (OperationTab) OperationTab1);
    private ImageModel model = new ImageModel();

    private GlobalViewController() {
    }

    public static GlobalViewController getInstance() {
        if (instance == null) {
            instance = new GlobalViewController();
        }
        return instance;
    }

    public void setPosition(Position pos) {
        if(pos != null){
            // creer snapshot
            if(pos.getTab() == OperationTab1)
                model.setPositionTab1(pos);

            else if(pos.getTab() == OperationTab2)
                model.setPositionTab2(pos);
        }
    }

    public void undoEvent() {
        CommandHistory.getInstance().pop();
        if(CommandHistory.getInstance().getCurrentHistoryElement() != null){
            Position currentPosition = CommandHistory.getInstance().getCurrentHistoryElement().getScreenPosition();
            if(currentPosition.getTab() == OperationTab1){
                model.setPositionTab1(currentPosition);
            }
            else if(currentPosition.getTab() == OperationTab2){
                model.setPositionTab2(currentPosition);
            }
        }

    }


    public void save(ImageModel model) {
        // Configure FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Serialized Object");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files", "*.ser"));

        // Show save file dialog
        File file = fileChooser.showSaveDialog(primaryStage);
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

    public void openFile(){
        // Configure FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Serialized Object");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files", "*.ser"));

        // Show open file dialog
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try (FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                ImageModel model = (ImageModel) in.readObject();
                System.out.println("Deserialized model...");
                this.model.setVersion(model);
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
    }

    public void load() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            model.setImageURL(selectedFile.toURI().toString());
        }
    }

    public Tab getStaticTab() {
        return staticTab;
    }

    public OperationTab getOperationTab1() {
        return OperationTab1;
    }

    public OperationTab getOperationTab2() {
        return OperationTab2;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }


    public ImageModel getModel() {
        return model;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
