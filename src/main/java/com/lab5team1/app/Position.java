package com.lab5team1.app;

public class Position {
    private int xPos;
    private int yPos;
    private float zoomValue;
    private OperationTab tab;

    public Position(int xPos, int yPos, float zoomValue, OperationTab tab) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zoomValue = zoomValue;
        this.tab = tab;
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
