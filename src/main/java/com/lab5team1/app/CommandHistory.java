package com.lab5team1.app;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private int HISTORY_MAX_SIZE = 10;
    private static CommandHistory instance;
    private List<SnapShot> history = new ArrayList<>();
    private List<SnapShot> redoHistory = new ArrayList<>();

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

    public SnapShot pop() {
        if (!history.isEmpty()) {
            SnapShot snapshot = history.removeLast();
            redoHistory.add(snapshot);
            System.out.println(history.toString());
            return snapshot;
        }
        return null; // Or throw an exception if preferred
    }

    public void push(SnapShot snapshot) {
        history.add(snapshot);
        cropListToLength();
        clearRedoHistory();
        System.out.println(history.toString());
    }

    private void cropListToLength() {
        while (history.size() > HISTORY_MAX_SIZE) {
            history.removeLast();
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
