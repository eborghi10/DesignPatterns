package com.example.sharingapp;

import android.content.Context;

/**
 * Command to delete an item
 */

public class DeleteItemCommand extends Command {

    private ItemList mItemList;
    private Item mItem;
    private Context mContext;

    public DeleteItemCommand(ItemList itemList, Item item, Context context) {
        this.mItemList = itemList;
        this.mItem = item;
        this.mContext = context;
    }

    @Override
    public void execute() {
        mItemList.deleteItem(mItem);
        setIsExecuted(mItemList.saveItems(mContext));
    }
}
