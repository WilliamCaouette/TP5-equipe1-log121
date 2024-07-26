package com.lab5team1.app;


public class ChangePosition extends ICommand {
    private Position position;

    public ChangePosition(Position pos) {
        position = pos;
    }

    @Override
    void execute() {
        receiver.setPosition(position);
    }
}
