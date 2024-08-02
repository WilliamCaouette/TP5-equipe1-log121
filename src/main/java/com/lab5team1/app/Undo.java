package com.lab5team1.app;

public class Undo extends ICommand {

    public Undo(){

    }

    @Override
    void execute() {
        GlobalViewController.getInstance().undoEvent();
    }
}
