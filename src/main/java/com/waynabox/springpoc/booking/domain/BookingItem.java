package com.waynabox.springpoc.booking.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * .
 */
public class BookingItem {

    private int id;

    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("avail")
    private boolean avail;

    @SerializedName("level")
    private int priceLevel;

    private int price;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public boolean isAvailable() {
        return avail;
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
