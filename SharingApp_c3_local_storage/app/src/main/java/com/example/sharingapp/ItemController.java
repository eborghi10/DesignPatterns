package com.example.sharingapp;

import android.graphics.Bitmap;

/**
 * ItemController is responsible for all communication between views and Item model
 */

public class ItemController {

    private Item item;

    public ItemController(Item item){
        this.item = item;
    }

    public String getId(){
        return item.getId();
    }

    public void setId() {
        item.setId();
    }

    public void setTitle(String title) {
        item.setTitle(title);
    }

    public String getTitle() {
        return item.getTitle();
    }

    public void setMaker(String maker) {
        item.setMaker(maker);
    }

    public String getMaker() {
        return item.getMaker();
    }

    public void setDescription(String description) {
        item.setDescription(description);
    }

    public String getDescription() {
        return item.getDescription();
    }

    public Float getMinBid() {
        return item.getMinBid();
    }

    public void setMinBid(Float bid) {
        item.setMinBid(bid);
    }

    public void setOwnerId(String owner_id) {
        item.setOwnerId(owner_id);
    }

    public String getOwnerId() {
        return item.getOwnerId();
    }

    public void setDimensions(String length, String width, String height) {
        item.setDimensions(length, width, height);
    }

    public String getLength(){
        return item.getLength();
    }

    public String getWidth(){
        return item.getWidth();
    }

    public String getHeight(){
        return item.getHeight();
    }

    public void setStatus(String status) {
        item.setStatus(status);
    }

    public String getStatus() {
        return item.getStatus();
    }

    public void setBorrower(User borrower) {
        item.setBorrower(borrower);
    }

    public User getBorrower() {
        return item.getBorrower();
    }

    public void addImage(Bitmap new_image){
        item.addImage(new_image);
    }

    public Bitmap getImage(){
        return item.getImage();
    }

    public Item getItem() { return this.item; }

    public void addObserver(Observer observer) {
        item.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        item.removeObserver(observer);
    }
}
