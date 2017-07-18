package com.waynabox.springpoc.booking.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The result of a pack call
 */
public class BookingPackItem {
    private int departureId;
    private int numberOfDays;

    @SerializedName("error")
    private boolean error;

    @SerializedName("dates")
    @Expose
    private List<BookingItem> dates;

    public static BookingPackItem create(int departureId, int numberOfDays, String jsonResponse) {
        Gson gson = new Gson();
        BookingPackItem bookingPackItem = gson.fromJson(jsonResponse, BookingPackItem.class);
        bookingPackItem.departureId = departureId;
        bookingPackItem.numberOfDays = numberOfDays;
        return bookingPackItem;
    }

    public int getDepartureId() {
        return departureId;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public boolean isError() {
        return error;
    }

    public List<BookingItem> getDates() {
        return dates;
    }

    public void setDepartureId(int departureId) {
        this.departureId = departureId;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
