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
    private boolean error;
    private List<BookingItem> dates;

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
