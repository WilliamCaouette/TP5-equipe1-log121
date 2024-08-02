package com.lab5team1.app;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Subject.
 */
public abstract class Subject{
    /**
     * The Observers.
     */
    protected List<Observer>  observers = new ArrayList<>();

    /**
     * Subscribe.
     *
     * @param o the o
     */
    public void subscribe(Observer o) {
        observers.add(o);
    }

    /**
     * Unsubscribe.
     *
     * @param o the o
     */
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    /**
     * Notify observers.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.getNotify(this);
        }
    }
}
