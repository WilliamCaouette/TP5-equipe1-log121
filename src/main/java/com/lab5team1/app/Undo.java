package com.lab5team1.app;

/**
 * The type Undo.
 */
public class Undo extends ICommand {

    @Override
    void execute() {
        System.out.println("Undo command executed");
        SnapShot snapshot = CommandHistory.getInstance().pop(this);
        if (snapshot != null) {
            Position pos = snapshot.getScreenPosition();
            System.out.println("Undo: Restoring position to " + pos);
            GlobalViewController.getInstance().setPosition(pos);
        }else {
            System.out.println("Undo: No snapshot found");
        }
    }
}