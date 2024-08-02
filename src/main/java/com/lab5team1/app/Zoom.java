package com.lab5team1.app;

/**
 * The type Zoom.
 */
public class Zoom extends ICommand {
    private Position position;
    private double deltaScroll;
    private final double zoomFactor = 0.1;

    /**
     * Instantiates a new Zoom.
     *
     * @param pos         the pos
     * @param deltaScroll the delta scroll
     */
    public Zoom(Position pos,double deltaScroll){
        this.deltaScroll = deltaScroll;
        this.position = pos;
        execute();
    }

    @Override
    void execute() {
        double delta = deltaScroll > 0 ? zoomFactor : -zoomFactor;
        double newScaleValue = position.getZoom() + delta;
        newScaleValue = clamp(newScaleValue, 0.1, 10);
        position.setZoom(newScaleValue);
        receiver.setPosition(position);
    }

    private double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

}
