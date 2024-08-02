package com.lab5team1.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The type Command history.
 */
public class CommandHistory {
    private int HISTORY_MAX_SIZE = 10;
    private static CommandHistory instance;
    private Stack<SnapShot> history = new Stack<>();
    private Stack<SnapShot> redoHistory = new Stack<>();

    private CommandHistory() {}

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CommandHistory getInstance() {
        if (instance == null) {
            instance = new CommandHistory();
        }
        return instance;
    }

    /**
     * Clear redo history.
     */
    public void clearRedoHistory() {
        redoHistory.clear();
    }

    /**
     * Clear history.
     */
    public void clearHistory() {
        history.clear();
    }

    /**
     * Pop snap shot.
     *
     * @param typeCommand the type command
     * @return the snap shot
     */
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


    /**
     * Push.
     *
     * @param snapshot the snapshot
     */
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

    /**
     * Gets history.
     *
     * @return the history
     */
    public List<SnapShot> getHistory() {
        return history;
    }

    /**
     * Gets current history element.
     *
     * @return the current history element
     */
    public SnapShot getCurrentHistoryElement() {
        if (!history.isEmpty()) {
            return history.getLast();
        }
        return null; // Or throw an exception if preferred
    }
}
