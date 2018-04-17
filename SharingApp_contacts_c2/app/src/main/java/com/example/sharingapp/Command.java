package com.example.sharingapp;

/**
 * Superclass of AddContactCommand, EditContactCommand, DeleteContactCommand,
 * AddItemCommand, EditItemCommand, DeleteItemCommand
 */

public abstract class Command {
    private boolean mIsExecuted;

    public Command() {
        mIsExecuted = false;
    }

    public abstract void execute();

    public boolean isExecuted(){
        return mIsExecuted;
    }

    public void setIsExecuted(boolean isExecuted){
        this.mIsExecuted = isExecuted;
    }
}
