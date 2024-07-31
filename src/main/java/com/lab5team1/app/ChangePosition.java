package com.lab5team1.app;


import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class ChangePosition extends ICommand {
    private Position position;
    private double deltaX;
    private double deltaY;
    private double height;
    private double width;


    public ChangePosition(Position pos,double deltaX, double deltaY, double height, double width){
        this.position = pos;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.width = width;
        this.height = height;
        this.execute();
    }

    @Override
    void execute() {
        double newHValue = position.getXPos() - deltaX / height;
        double newVValue = position.getYPos() - deltaY / width;
        position.setYPos(clamp(newVValue,0,1));
        position.setXPos(clamp(newHValue,0,1));
        receiver.setPosition(position);
    }

    private double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

}
