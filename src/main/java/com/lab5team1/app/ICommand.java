package com.lab5team1.app;

/**
 * The type Command.
 */
public abstract class ICommand {
    /**
     * The Receiver.
     */
    protected GlobalViewController receiver = GlobalViewController.getInstance();

    /**
     * Execute.
     */
    abstract void execute();
}
