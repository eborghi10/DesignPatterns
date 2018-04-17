package com.example.sharingapp;

import android.content.Context;

public class EditContactCommand extends Command {

    private ContactList mContactList;
    private Contact mOldContact;
    private Contact mNewContact;
    private Context mContext;

    public EditContactCommand(ContactList contactList, Contact oldContact, Contact newContact, Context context) {
        this.mContactList = contactList;
        this.mOldContact = oldContact;
        this.mNewContact = newContact;
        this.mContext = context;
    }

    @Override
    public void execute() {
        mContactList.deleteContact(mOldContact);
        mContactList.addContact(mNewContact);
        setIsExecuted(mContactList.saveContacts(mContext));
    }
}
