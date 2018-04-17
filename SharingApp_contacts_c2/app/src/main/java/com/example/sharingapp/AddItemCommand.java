package com.example.sharingapp;

import android.content.Context;

/**
 * Command to add item
 */

public class AddItemCommand extends Command {

    private ItemList mItemList;
    private Item mItem;
    private Context mContext;

    public AddItemCommand(ItemList itemList, Item item, Context context) {
        this.mItemList = itemList;
        this.mItem = item;
        this.mContext = context;
    }

    @Override
    public void execute() {
        mItemList.addItem(mItem);
        setIsExecuted(mItemList.saveItems(mContext));
    }
}
