package com.lab5team1.app;

import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

public class GlobalViewController {
    private static GlobalViewController instance;

    private Tab staticTab = new StaticTab();
    private OperationTab OperationTab1 = new OperationTab();
    private OperationTab OperationTab2 = new OperationTab();
    private ToolBar toolBar;

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
        // creer snapshot
        model.setPositionTab1(pos);
    }

    public void setZoom(float zoom) {
    }

    public void undoEvent() {
    }

    public void saveSnapShot(Position position) {
    }

    public void save(ImageModel model) {
    }

    public void load() {}

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

    public void setToolBar(Stage stage) {
        this.toolBar = new ToolBar(stage);
    }

    public ImageModel getModel() {
        return model;
    }
}
