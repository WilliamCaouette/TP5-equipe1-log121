package com.lab5team1.app;

import java.io.Serializable;

/**
 * The type Image model.
 */
public class ImageModel extends Subject implements Serializable {
    private Position positionTab1;
    private Position positionTab2;
    private String imageURL;

    /**
     * Sets position tab 1.
     *
     * @param positionTab1 the position tab 1
     */
    public void setPositionTab1(Position positionTab1) {
        this.positionTab1 = positionTab1;
        notifyObservers();
    }

    /**
     * Sets position tab 2.
     *
     * @param positionTab2 the position tab 2
     */
    public void setPositionTab2(Position positionTab2) {
        this.positionTab2 = positionTab2;
        notifyObservers();
    }

    /**
     * Set image url.
     *
     * @param url the url
     */
    public void setImageURL(String url){
        this.imageURL = url;
        //this.positionTab1 = resetTabPositions(this.positionTab1);
        //this.positionTab2 = resetTabPositions(this.positionTab2);
        notifyObservers();
    }

    private Position resetTabPositions(Position pos) {
        if (pos != null)
            return new Position(0.0,0.0,0.0, (OperationTab) pos.getTab());
        else
            return pos;
    }

    /**
     * Set version.
     *
     * @param imageModel the image model
     */
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

    /**
     * Gets position tab 2.
     *
     * @return the position tab 2
     */
    public Position getPositionTab2() {
        return positionTab2;
    }

    /**
     * Gets position tab 1.
     *
     * @return the position tab 1
     */
    public Position getPositionTab1() {
        return positionTab1;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageURL() {
        return imageURL;
    }
}
