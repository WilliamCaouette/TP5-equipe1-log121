package com.lab5team1.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class OperationTab extends Tab{
    ScrollPane scrollPane;
    Position position = new Position(0d, 0d, 1f, this);


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
        // Create a ScrollPane and put the VBox inside it
        ScrollPane scrollPane = new ScrollPane(vbox);

        scrollPane.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                position.setXPos((Double) newValue);
            }
        });

        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                position.setYPos((Double) newValue);
            }
        });

        // Set the preferred size of the ScrollPane
        scrollPane.setPrefSize(500, 500);
        scrollPane.setOnMouseClicked(event -> handleMouseClick(event));
        // Disable scrolling
        scrollPane.setPannable(false);
        root.getChildren().add(scrollPane);
        return root;
    }

    private void handleMouseClick(MouseEvent event) {
        this.position.setZoom(this.position.getZoom()+0.1f);
        imageView.setScaleX(this.position.getZoom());
        imageView.setScaleY(this.position.getZoom());
    }
}
