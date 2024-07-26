package com.lab5team1.app;

public abstract class ICommand {
    protected GlobalViewController receiver;

    abstract void execute();
}
