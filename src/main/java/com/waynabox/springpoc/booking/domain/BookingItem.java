package com.waynabox.springpoc.booking.domain;

public class BookingItem {

    private int id;
    private String from;
    private String to;
    private boolean avail;
    private int level;
    private int price;


    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public boolean isAvail() {
        return avail;
    }

    public int getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }
}
