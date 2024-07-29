package com.lab5team1.app;

public abstract class ICommand {
    protected GlobalViewController receiver = GlobalViewController.getInstance();

    abstract void execute();
}
