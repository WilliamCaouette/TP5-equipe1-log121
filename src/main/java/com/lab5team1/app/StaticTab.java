package com.lab5team1.app;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

public class StaticTab extends Tab {


    @Override
    public VBox buildTab() {
        VBox root = new VBox();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        if (this.imageURL != "") {
            Image image = new Image(this.imageURL);
            imageView.setImage(image);
        }
         root.getChildren().add(imageView);
        return root;
    }
}
