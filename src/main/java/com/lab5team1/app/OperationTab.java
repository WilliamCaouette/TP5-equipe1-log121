package com.lab5team1.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;

public class OperationTab extends Tab{
    ScrollPane scrollPane;
    Position position = new Position(0d, 0d, 1f, this);
    private double lastMouseX;
    private double lastMouseY;
    private double scaleValue = 1.0;
    private final double zoomFactor = 0.1;



    @Override
    public VBox  buildTable() {
        VBox root = new VBox();
        VBox vbox = new VBox();
        imageView.setPreserveRatio(true);
        if (this.imageURL != "") {
            Image image = new Image(this.imageURL);
            imageView.setImage(image);
        }
        vbox.getChildren().add(imageView);
        vbox.maxWidth(300);
        scrollPane = new ScrollPane(vbox);
        // Masquer les barres de défilement
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Ajouter des gestionnaires d'événements pour le drag
        vbox.setOnMousePressed(this::handleMousePressed);
        vbox.setOnMouseDragged(event -> handleMouseDragged(event, scrollPane));

        // Ajouter un EventHandler pour gérer le zoom
        scrollPane.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.getDeltaY() != 0) {
                double delta = event.getDeltaY() > 0 ? zoomFactor : -zoomFactor;
                double deltaX = event.getSceneX() - lastMouseX;
                double deltaY = event.getSceneY() - lastMouseY;
                // Si ça fonctionne, possiblement mettre imageView et event dans Position,
                // ou trouver meilleur moyen de transferer ça
                Position position1 = new Position(deltaX, deltaY, delta, this);
                ChangePosition changePosition = new ChangePosition(position1);
                changePosition.execute();
                event.consume();
            }
        });


        scrollPane.setPrefSize(500, 500);

        // Disable scrolling
        scrollPane.setPannable(false);
        root.getChildren().add(scrollPane);
        return root;
    }

    private void handleMousePressed(MouseEvent event) {
        System.out.println("here");
        lastMouseX = event.getSceneX();
        lastMouseY = event.getSceneY();
    }

    private void handleMouseDragged(MouseEvent event, ScrollPane scrollPane) {
        double deltaX = event.getSceneX() - lastMouseX;
        double deltaY = event.getSceneY() - lastMouseY;

        double newHValue = scrollPane.getHvalue() - deltaX / scrollPane.getContent().getBoundsInLocal().getWidth();
        double newVValue = scrollPane.getVvalue() - deltaY / scrollPane.getContent().getBoundsInLocal().getHeight();

        scrollPane.setHvalue(clamp(newHValue, 0, 1));
        scrollPane.setVvalue(clamp(newVValue, 0, 1));

        lastMouseX = event.getSceneX();
        lastMouseY = event.getSceneY();

        this.position.setXPos(scrollPane.getHvalue());
        this.position.setYPos(scrollPane.getVvalue());

    }

    private double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public void updateView(Position pos) {
        double delta = pos.getYPos() > 0 ? zoomFactor : -zoomFactor;
        scaleValue += delta;
        scaleValue = clamp(scaleValue, 0.1, 10);
        imageView.setScaleX(scaleValue);
        imageView.setScaleY(scaleValue);
        this.position.setZoom(scaleValue);
    }
}
