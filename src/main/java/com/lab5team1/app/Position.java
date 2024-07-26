package com.lab5team1.app;

public class Position {
    private int xPos;
    private int yPos;
    private float zoomValue;

    public Position(int xPos, int yPos, float zoomValue) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zoomValue = zoomValue;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public float getZoom() {
        return zoomValue;
    }

    public void setZoom(float zoomValue) {
        this.zoomValue = zoomValue;
    }

    @Override
    public String toString() {
        return "Position{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", zoomValue=" + zoomValue +
                '}';
    }
}
