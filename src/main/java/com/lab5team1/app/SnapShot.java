package com.lab5team1.app;

public class SnapShot {
    private Position[] screensPositions;

    public SnapShot(Position[] screensPositions) {
        this.screensPositions = screensPositions;
    }

    public Position[] getScreensPositions() {
        return screensPositions;
    }

    public Position getScreenPosition(int id) {
        if (id >= 0 && id < screensPositions.length) {
            return screensPositions[id];
        }
        return null; // Or throw an exception if preferred
    }
}
