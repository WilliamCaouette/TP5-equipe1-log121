package com.lab5team1.app;


import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class ChangePosition extends ICommand {
    private Position position;
    private ScrollEvent scrollEvent;
    private ImageView iView;

    public ChangePosition(Position pos, ScrollEvent event, ImageView imageView)
    {
        position = pos;
        scrollEvent = event;
        iView = imageView;
    }

    @Override
    void execute() {
        receiver.setPosition(position, scrollEvent, iView);
    }
}
