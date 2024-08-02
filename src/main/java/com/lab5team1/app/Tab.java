package com.lab5team1.app;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * The type Tab.
 */
public abstract class Tab {
    /**
     * The Image url.
     */
    protected String imageURL = "";
    /**
     * The Image view.
     */
    protected ImageView imageView = new ImageView();

    /**
     * Set image url.
     *
     * @param url the url
     */
    public void setImageURL(String url){
        imageURL = url;
        updateTab();
    }

    /**
     * Update tab.
     */
    public void updateTab() {
        imageView.setImage( new Image(this.imageURL));
    }

    /**
     * Build tab v box.
     *
     * @return the v box
     */
    public abstract VBox buildTab();
}
