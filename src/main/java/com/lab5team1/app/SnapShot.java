package com.lab5team1.app;

/**
 * The type Snap shot.
 */
public class SnapShot {
    private Position screenPosition;

    /**
     * Instantiates a new Snap shot.
     *
     * @param screenPosition the screen position
     */
    public SnapShot(Position screenPosition) {
        this.screenPosition = screenPosition;
    }


    /**
     * Gets screen position.
     *
     * @return the screen position
     */
    public Position getScreenPosition() {
        return screenPosition;
    }
}
