package com.example.sharingapp;

import android.content.Context;

public class DeleteContactCommand extends Command {

    private ContactList mContactList;
    private Contact mContact;
    private Context mContext;

    public DeleteContactCommand(ContactList contactList, Contact contact, Context context) {
        this.mContactList = contactList;
        this.mContact = contact;
        this.mContext = context;
    }

    @Override
    public void execute() {
        mContactList.deleteContact(mContact);
        setIsExecuted(mContactList.saveContacts(mContext));
    }
}
