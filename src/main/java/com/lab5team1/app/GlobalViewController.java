package com.lab5team1.app;

public class GlobalViewController {
    private GlobalViewController instance;

    private GlobalViewController() {
    }

    public GlobalViewController getInstance() {
        if (instance == null) {
            instance = new GlobalViewController();
        }
        return instance;
    }

    public void setPosition(Position pos) {
        // creer snapshot
    }

    public void setZoom(float zoom) {
    }

    public void undoEvent() {
    }

    public void saveSnapShot(Position position) {
    }

    public void save(ImageModel model) {
    }

    public void load() {}

}
