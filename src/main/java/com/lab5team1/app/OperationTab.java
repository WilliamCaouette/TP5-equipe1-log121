package com.lab5team1.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;

import java.io.Serializable;

public class OperationTab extends Tab implements Serializable {
    ScrollPane scrollPane;
    Position position;
    private double lastMouseX;
    private double lastMouseY;

    public OperationTab(){
        position = new Position(0d, 0d, 1f, this);
    }


    @Override
    public VBox buildTab() {
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
        vbox.setOnMouseReleased(this::handleMouseReleased);
        vbox.setOnMouseDragged(event -> handleMouseDragged(event, scrollPane));

        // Ajouter un EventHandler pour gérer le zoom
        scrollPane.addEventFilter(ScrollEvent.SCROLL, event -> {
            zoomImage(event);
        });


        scrollPane.setPrefSize(500, 500);

        // Disable scrolling
        scrollPane.setPannable(false);
        root.getChildren().add(scrollPane);
        return root;
    }

    private void handleMouseReleased(MouseEvent mouseEvent) {
       CommandHistory.getInstance().push(position.save());
    }

    private void handleMousePressed(MouseEvent event) {
        lastMouseX = event.getSceneX();
        lastMouseY = event.getSceneY();
    }

    private void handleMouseDragged(MouseEvent event, ScrollPane scrollPane) {
        new ChangePosition(this.position, event.getSceneX() - lastMouseX, event.getSceneY() - lastMouseY, scrollPane.getContent().getBoundsInLocal().getWidth(), scrollPane.getContent().getBoundsInLocal().getHeight());
        lastMouseX = event.getSceneX();
        lastMouseY = event.getSceneY();

    }


    public void updateView(Position pos) {
        if(pos != null){
            scrollPane.setHvalue(pos.getXPos());
            scrollPane.setVvalue(pos.getYPos());
            imageView.setScaleX(pos.getZoom());
            imageView.setScaleY(pos.getZoom());
        }

    }

    private void zoomImage(ScrollEvent event) {
        new Zoom(this.position, event.getDeltaY());
        event.consume();
    }
}
