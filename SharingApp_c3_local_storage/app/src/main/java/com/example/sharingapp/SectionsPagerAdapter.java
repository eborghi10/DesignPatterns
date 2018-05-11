package com.example.sharingapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private String user_id;

    public SectionsPagerAdapter(FragmentManager fm, String user_id) {
        super(fm);
        this.user_id = user_id;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);
        switch (position) {
            case 0:
                AllItemsFragment all_items_fragment = new AllItemsFragment();
                all_items_fragment.setArguments(bundle);
                return all_items_fragment;
            case 1:
                AvailableItemsFragment available_items_fragment = new AvailableItemsFragment();
                available_items_fragment.setArguments(bundle);
                return available_items_fragment;
            case 2:
                BiddedItemsFragment bidded_items_fragment = new BiddedItemsFragment();
                bidded_items_fragment.setArguments(bundle);
                return bidded_items_fragment;
            case 3:
                BorrowedItemsFragment borrowed_items_fragment = new BorrowedItemsFragment();
                borrowed_items_fragment.setArguments(bundle);
                return borrowed_items_fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;  // Four pages
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "All";
            case 1:
                return "Available";
            case 2:
                return "Bidded";
            case 3:
                return "Borrowed";

        }
        return null;
    }
}