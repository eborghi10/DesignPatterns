package com.example.sharingapp;

/**
 * Superclass of AddUserCommand, EditUserCommand, AddItemCommand, EditItemCommand, DeleteItemCommand,
 * AddBidCommand, and DeleteBidCommand
 */
public abstract class Command {

    private boolean is_executed;

    public Command(){
        is_executed = false;
    }

    public abstract void execute();

    public boolean isExecuted(){
        return is_executed;
    }

    public void setIsExecuted(boolean is_executed) {
        this.is_executed = is_executed;
    }
}
