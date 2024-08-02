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

    public void pop() {
        if (!history.isEmpty()) {
            redoHistory.add(history.pop());
        }
    }

    public void push(SnapShot snapshot) {
        history.push(snapshot);
        cropListToLength();
        clearRedoHistory();
        System.out.println("ajout de la position : " + history.get(0).toString());

    }

    private void cropListToLength() {
        while (history.size() > HISTORY_MAX_SIZE) {
            history.removeFirst();
        }
    }

    public List<SnapShot> getHistory() {
        return history;
    }

    public SnapShot getCurrentHistoryElement() {
        if (!history.isEmpty()) {
            System.out.println("renvoie la position : " + history.get(history.size() -1).toString());
            return history.getFirst();
        }
        return null; // Or throw an exception if preferred
    }
}
