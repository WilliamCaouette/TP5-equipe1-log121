package com.lab5team1.app;

/**
 * The type Redo.
 */
public class Redo extends ICommand{
    @Override
    void execute() {
        //System.out.println("Redo command executed");
        SnapShot snapshot = CommandHistory.getInstance().pop(this);
        if (snapshot != null) {
            Position pos = snapshot.getScreenPosition();
            //System.out.println("Redo: Restoring position to " + pos);
            GlobalViewController.getInstance().setPosition(pos);
        } else {
            //System.out.println("Redo: No snapshot found");
        }
    }
}
