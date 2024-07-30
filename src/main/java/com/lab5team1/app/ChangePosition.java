package com.lab5team1.app;


import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class ChangePosition extends ICommand {
    private Position position;

    public ChangePosition(Position pos)
    {
        position = pos;
    }

    @Override
    void execute() {
        // cal delta
        receiver.setPosition(position);
    }
}
