package com.lab5team1.app;

import java.io.Serializable;

/**
 * The type Position.
 */
public class Position implements Serializable {
    private double xPos;
    private double yPos;
    private double zoomValue;
    private transient OperationTab tab;

    /**
     * Instantiates a new Position.
     *
     * @param xPos      the x pos
     * @param yPos      the y pos
     * @param zoomValue the zoom value
     * @param tab       the tab
     */
    public Position(double xPos, double yPos, double zoomValue, OperationTab tab) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zoomValue = zoomValue;
        this.tab = tab;
    }

    /**
     * Gets x pos.
     *
     * @return the x pos
     */
    public Double getXPos() {
        return xPos;
    }

    /**
     * Sets x pos.
     *
     * @param xPos the x pos
     */
    public void setXPos(Double xPos) {
        this.xPos = xPos;
        //System.out.println(this.toString());
    }

    /**
     * Gets y pos.
     *
     * @return the y pos
     */
    public Double getYPos() {
        return yPos;
    }

    /**
     * Sets y pos.
     *
     * @param yPos the y pos
     */
    public void setYPos(Double yPos) {
        this.yPos = yPos;
        //System.out.println(this.toString());
    }

    /**
     * Gets zoom.
     *
     * @return the zoom
     */
    public double getZoom() {
        return zoomValue;
    }

    /**
     * Sets zoom.
     *
     * @param zoomValue the zoom value
     */
    public void setZoom(double zoomValue) {
        this.zoomValue = zoomValue;
        //System.out.println(this.toString());
    }

    public Position clone(){
        return new Position(xPos, yPos,zoomValue,tab);
    }

    /**
     * Get tab tab.
     *
     * @return the tab
     */
    public Tab getTab(){
        return this.tab;
    }

    /**
     * Save snap shot.
     *
     * @return the snap shot
     */
    public SnapShot save(){
        return new SnapShot(this);
    }

    /**
     * Restore.
     *
     * @param snapShot the snap shot
     */
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
