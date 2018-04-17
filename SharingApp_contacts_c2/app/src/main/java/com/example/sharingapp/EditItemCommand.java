package com.example.sharingapp;

import android.content.Context;

/**
 * Command to edit a pre-existing item
 */

public class EditItemCommand extends Command {

    private ItemList mItemList;
    private Item mOldItem;
    private Item mNewItem;
    private Context mContext;

    public EditItemCommand(ItemList itemList, Item oldItem, Item newItem, Context context) {
        this.mItemList = itemList;
        this.mOldItem = oldItem;
        this.mNewItem = newItem;
        this.mContext = context;
    }

    @Override
    public void execute() {
        mItemList.deleteItem(mOldItem);
        mItemList.addItem(mNewItem);
        setIsExecuted(mItemList.saveItems(mContext));
    }
}
