package com.lab5team1.app;

import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

public class GlobalViewController {
    private static GlobalViewController instance;

    private Tab staticTab = new StaticTab();
    private Tab OperationTab1 = new OperationTab();
    private Tab OperationTab2 = new OperationTab();
    private ToolBar toolBar;

    Position position = new Position(0d, 0d, 1.0, (OperationTab) OperationTab1);

    private double lastMouseX;
    private double lastMouseY;
    private double scaleValue = 1.0;
    private final double zoomFactor = 0.1;

    private GlobalViewController() {
    }

    public static GlobalViewController getInstance() {
        if (instance == null) {
            instance = new GlobalViewController();
        }
        return instance;
    }

    public void setPosition(Position pos, ScrollEvent event, ImageView imageView) {
        // creer snapshot
        // i guess qu'ici ça serait de faire ce que le tab fait avec l'imageView, plus update le model
        double delta = pos.getYPos() > 0 ? zoomFactor : -zoomFactor;
        scaleValue += delta;
        scaleValue = clamp(scaleValue, 0.1, 10);
        imageView.setScaleX(scaleValue);
        imageView.setScaleY(scaleValue);
        event.consume();
        this.position.setZoom(scaleValue);
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

    public Tab getOperationTab1() {
        return OperationTab1;
    }

    public Tab getOperationTab2() {
        return OperationTab2;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(Stage stage) {
        this.toolBar = new ToolBar(stage);
    }

    private double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
