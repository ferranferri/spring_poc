package com.waynabox.springpoc.booking.model;

import com.google.gson.annotations.SerializedName;

/**
 * .
 */
public class BookingItem {

    private int id;

    @SerializedName("from")
    private String fromDate;

    @SerializedName("to")
    private String toDate;

    @SerializedName("avail")
    private boolean available;

    @SerializedName("level")
    private int priceLevel;

    private int price;

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getPriceLevel() {
        return priceLevel;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
