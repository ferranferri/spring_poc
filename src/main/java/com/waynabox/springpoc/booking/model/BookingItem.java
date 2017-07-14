package com.waynabox.springpoc.booking.model;

import com.google.gson.annotations.SerializedName;

/**
 * .
 */
public class BookingItem {
    int id;

    @SerializedName("from")
    String fromDate;

    @SerializedName("to")
    String toDate;

    @SerializedName("avail")
    boolean available;

    @SerializedName("level")
    int priceLevel;

    int price;
}
