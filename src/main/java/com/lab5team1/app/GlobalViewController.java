package com.lab5team1.app;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

/**
 * The type Global view controller.
 */
public class GlobalViewController {
    private static GlobalViewController instance;

    private Tab staticTab = new StaticTab();
    private OperationTab OperationTab1 = new OperationTab();
    private OperationTab OperationTab2 = new OperationTab();
    private ToolBar toolBar = new ToolBar();
    private Stage primaryStage;

    /**
     * The Position.
     */
    Position position = new Position(0d, 0d, 1.0, (OperationTab) OperationTab1);
    private ImageModel model = new ImageModel();

    private GlobalViewController() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static GlobalViewController getInstance() {
        if (instance == null) {
            instance = new GlobalViewController();
        }
        return instance;
    }

    /**
     * Sets position.
     *
     * @param pos the pos
     */
    public void setPosition(Position pos) {
        if(pos != null) {
            if (pos.getTab() == OperationTab1){
                model.setPositionTab1(pos);
            } else if(pos.getTab() == OperationTab2) {
                model.setPositionTab2(pos);
            }
        }
    }

    /**
     * Undo event.
     */
    public void undoEvent() {
        System.out.println("undo exec");
        new Undo().execute();
    }

    /**
     * Redo event.
     */
    public void redoEvent() {
        System.out.println("redo exec");
        new Redo().execute();
    }

    /**
     * Save.
     *
     * @param model the model
     */
    public void save(ImageModel model) {
        Save save = new Save(model, primaryStage);
        save.execute();
    }

    /**
     * Open file.
     */
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

    /**
     * Load.
     */
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


    /**
     * Gets static tab.
     *
     * @return the static tab
     */
    public Tab getStaticTab() {
        return staticTab;
    }

    /**
     * Gets operation tab 1.
     *
     * @return the operation tab 1
     */
    public OperationTab getOperationTab1() {
        return OperationTab1;
    }

    /**
     * Gets operation tab 2.
     *
     * @return the operation tab 2
     */
    public OperationTab getOperationTab2() {
        return OperationTab2;
    }

    /**
     * Gets tool bar.
     *
     * @return the tool bar
     */
    public ToolBar getToolBar() {
        return toolBar;
    }


    /**
     * Gets model.
     *
     * @return the model
     */
    public ImageModel getModel() {
        return model;
    }

    /**
     * Sets primary stage.
     *
     * @param primaryStage the primary stage
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
