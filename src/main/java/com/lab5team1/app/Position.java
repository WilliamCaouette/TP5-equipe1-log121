package com.lab5team1.app;

import java.io.Serializable;

public class Position implements Serializable {
    private double xPos;
    private double yPos;
    private double zoomValue;
    private transient OperationTab tab;

    public Position(double xPos, double yPos, double zoomValue, OperationTab tab) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zoomValue = zoomValue;
        this.tab = tab;
    }

    public Double getXPos() {
        return xPos;
    }

    public void setXPos(Double xPos) {
        this.xPos = xPos;
        //System.out.println(this.toString());
    }

    public Double getYPos() {
        return yPos;
    }

    public void setYPos(Double yPos) {
        this.yPos = yPos;
        //System.out.println(this.toString());
    }

    public double getZoom() {
        return zoomValue;
    }

    public void setZoom(double zoomValue) {
        this.zoomValue = zoomValue;
        //System.out.println(this.toString());
    }

    public Position clone(){
        return new Position(xPos, yPos,zoomValue,tab);
    }

    public Tab getTab(){
        return this.tab;
    }

    public SnapShot save(){
        return new SnapShot(this);
    }

    public void restore(SnapShot snapShot){
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
