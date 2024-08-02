package com.lab5team1.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandHistory {
    private int HISTORY_MAX_SIZE = 10;
    private static CommandHistory instance;
    private Stack<SnapShot> history = new Stack<>();
    private Stack<SnapShot> redoHistory = new Stack<>();

    private CommandHistory() {}

    public static CommandHistory getInstance() {
        if (instance == null) {
            instance = new CommandHistory();
        }
        return instance;
    }

    public void clearRedoHistory() {
        redoHistory.clear();
    }
    public void clearHistory() {
        history.clear();
    }

    public SnapShot pop(ICommand typeCommand) {
        if (!history.isEmpty()&& typeCommand instanceof Undo) {
            redoHistory.add(history.pop());
            return this.getCurrentHistoryElement();
        }
        if (!redoHistory.isEmpty() && typeCommand instanceof Redo) {
            history.add(redoHistory.pop());
            return this.getCurrentHistoryElement();
        }
        return null; // Or throw an exception if preferred
    }



    public void push(SnapShot snapshot) {
        history.push(snapshot);
        cropListToLength();
        clearRedoHistory();
        System.out.println(history.toString());
    }

    private void cropListToLength() {
        while (history.size() > HISTORY_MAX_SIZE) {
            history.remove(0);
        }
    }

    public List<SnapShot> getHistory() {
        return history;
    }

    public SnapShot getCurrentHistoryElement() {
        if (!history.isEmpty()) {
            return history.getLast();
        }
        return null; // Or throw an exception if preferred
    }
}
