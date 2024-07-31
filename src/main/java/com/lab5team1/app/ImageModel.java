package com.lab5team1.app;

import javafx.beans.property.ListProperty;
import javafx.geometry.Pos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ImageModel extends Subject implements Serializable {
    private Position positionTab1;
    private Position positionTab2;
    private String imageURL;

    public void setPositionTab1(Position positionTab1) {
        this.positionTab1 = positionTab1;
        notifyObservers();
    }

    public void setPositionTab2(Position positionTab2) {
        this.positionTab2 = positionTab2;
        notifyObservers();
    }
    public void setImageURL(String url){
        this.imageURL = url;
        notifyObservers();
    }

    public void setVersion(ImageModel imageModel){
        setImageURL(imageModel.getImageURL());
        setPositionTab1(imageModel.getPositionTab1());
        setPositionTab2(imageModel.getPositionTab2());
        CommandHistory.getInstance().clearHistory();

    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
    public Position getPositionTab2() {
        return positionTab2;
    }
    public Position getPositionTab1() {
        return positionTab1;
    }

    public String getImageURL() {
        return imageURL;
    }
}
