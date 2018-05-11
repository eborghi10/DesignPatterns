package com.example.sharingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Displays a list of all "Bidded" items
 */
public class BiddedItemsFragment extends ItemsFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container, savedInstanceState);
        super.setUserId(this.getArguments());
        super.setVariables(R.layout.bidded_items_fragment, R.id.my_bidded_items);
        super.loadItems(BiddedItemsFragment.this);
        super.setFragmentOnItemLongClickListener();

        return rootView;
    }

    public ArrayList<Item> filterItems() {
        String status = "Bidded";
        return item_list_controller.filterItems(user_id, status);
    }
}