package com.example.sharingapp;

/**
 * BidController is responsible for all communication between views and Bid model
 */
public class BidController {
    private Bid bid;

    public BidController (Bid bid) {
        this.bid = bid;
    }

    public String getBidId() {
        return bid.getBidId();
    }

    public void setBidId() {
        bid.setBidId();
    }

    public String getItemId() {
        return bid.getItemId();
    }

    public void setItemId(String item_id) {
        bid.setItemId(item_id);
    }

    public void setbidAmount(float bid_amount) {
        bid.setBidAmount(bid_amount);
    }

    public Float getBidAmount() {
        return bid.getBidAmount();
    }

    public void setBidderUsername(String bidder_username) {
        bid.setBidderUsername(bidder_username);
    }

    public String getBidderUsername() {
        return bid.getBidderUsername();
    }

    public void addObserver(Observer observer) {
        bid.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        bid.removeObserver(observer);
    }
}
