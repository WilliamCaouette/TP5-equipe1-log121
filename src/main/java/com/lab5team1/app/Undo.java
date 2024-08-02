package com.lab5team1.app;

public class Undo extends ICommand {


    @Override
    void execute() {
        if (CommandHistory.getInstance().getCurrentHistoryElement() != null) {
            CommandHistory.getInstance().pop();
            if (CommandHistory.getInstance().getCurrentHistoryElement() != null) {
                receiver.setPosition(CommandHistory.getInstance().getCurrentHistoryElement().getScreenPosition());
            }
            else {
                //position initiale ou avant 10 changements
            }
        }
    }
}
