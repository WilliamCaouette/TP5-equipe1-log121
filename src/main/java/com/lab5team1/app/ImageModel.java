package com.lab5team1.app;

import javafx.beans.property.ListProperty;

public class ImageModel extends Subject{
    //private final SnapShot currentSnapShot;
    private Position positionTab1;
    private Position positionTab2;

    public Position getPositionTab1() {
        return positionTab1;
    }

    public void setPositionTab1(Position position) {
        positionTab1 = position;
        notifyObservers();
    }

    public Position getPositionTab2() {
        return positionTab2;
    }

    public void setPositionTab2(Position position) {
        positionTab2 = position;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}
