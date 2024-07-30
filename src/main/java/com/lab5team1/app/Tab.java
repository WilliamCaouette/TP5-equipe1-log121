package com.lab5team1.app;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public abstract class Tab {
    protected String imageURL = "";
    protected ImageView imageView = new ImageView();
    public void setImageURL(String url){
        imageURL = url;
        updateTab();
    }

    public void updateTab() {
        imageView.setImage( new Image(this.imageURL));
    }

    public abstract VBox buildTable();
}
