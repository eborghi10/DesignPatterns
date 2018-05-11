package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * BidList Class
 */
public class BidList extends Observable {
    private static ArrayList<Bid> bids;
    private String FILENAME = "bids.sav";

    public BidList() {
        bids = new ArrayList<Bid>();
    }

    public void setBids(ArrayList<Bid> bid_list) {
        bids = bid_list;
        notifyObservers();
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public void addBid(Bid bid){
        bids.add(bid);
        notifyObservers();
    }

    public void removeBid(Bid bid){
        bids.remove(bid);
        notifyObservers();
    }

    public Bid getBid(int index) {
        return bids.get(index);
    }

    public boolean isEmpty() {
        if (bids.isEmpty()) {
            return true;
        }
        return false;
    }

    public int getIndex(Bid bid) {
        int pos = 0;
        for (Bid b : bids) {
            if (bid.getBidId().equals(b.getBidId())) {
                return pos;
            }
            pos = pos + 1;
        }
        return -1;
    }

    public int getSize() {
        return bids.size();
    }

    // Used by getHighestBid and BidListController
    public ArrayList<Bid> getItemBids(String id){
        ArrayList<Bid> item_bids = new ArrayList<Bid>();
        for (Bid b : bids) {
            if (b.getItemId().equals(id)) {
                item_bids.add(b);
            }
        }
        return item_bids;
    }

    // Get highest bid_amount of all bids
    public Float getHighestBid(String id) {

        ArrayList<Bid> item_bids = getItemBids(id);

        if (item_bids.isEmpty()){
            return null;
        }

        Float highest_bid_amount = item_bids.get(0).getBidAmount(); // Initialize
        for (Bid b : item_bids) {
            if (b.getBidAmount() > highest_bid_amount) {
                highest_bid_amount = b.getBidAmount();
            }
        }

        return highest_bid_amount;
    }

    public String getHighestBidder(String id) {
        ArrayList<Bid> item_bids = getItemBids(id);

        if (item_bids.isEmpty()){
            return null;
        }

        Float highest_bid_amount = item_bids.get(0).getBidAmount(); // Initialize
        String highest_bidder = item_bids.get(0).getBidderUsername();
        for (Bid b : item_bids) {
            if (b.getBidAmount() > highest_bid_amount) {
                highest_bid_amount = b.getBidAmount();
                highest_bidder = b.getBidderUsername();
            }
        }

        return highest_bidder;
    }


    public void loadBids(Context context) {

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Bid>>() {
            }.getType();
            bids = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            bids = new ArrayList<Bid>();
        } catch (IOException e) {
            bids = new ArrayList<Bid>();
        }
        notifyObservers();
    }

    public boolean saveBids(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(bids, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
