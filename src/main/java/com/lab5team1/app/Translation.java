package com.lab5team1.app;


public class Translation extends ICommand {
    private Postion position;

    public Translation(Postion pos) {
        position = pos;
    }

    @Override
    void execute() {
        receiver.setTranslation(position);
    }
}
