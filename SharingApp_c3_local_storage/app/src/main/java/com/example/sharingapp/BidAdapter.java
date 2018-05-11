package com.example.sharingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * BidAdapter is responsible for what information is displayed in bid ListView entries.
 */
public class BidAdapter extends ArrayAdapter<Bid> {

    private LayoutInflater inflater;
    private Context context;

    public BidAdapter(Context context, ArrayList<Bid> bids) {
        super(context, 0, bids);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Bid bid = getItem(position);
        BidController bid_controller = new BidController(bid);

        String bidder = "Bidder: " + bid_controller.getBidderUsername();
        String bid_amount = "Bid: " + bid_controller.getBidAmount();

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null) {
            convertView = inflater.from(context).inflate(R.layout.bidlist_bid, parent, false);
        }

        TextView bidder_tv = (TextView) convertView.findViewById(R.id.bidder_tv);
        TextView bid_amount_tv = (TextView) convertView.findViewById(R.id.bid_amount_tv);

        bidder_tv.setText(bidder);
        bid_amount_tv.setText(bid_amount);

        return convertView;
    }
}
