package com.waynabox.springpoc.booking.model;

import com.google.gson.Gson;
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
    List<BookingItem> listOfSlots;

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

    public List<BookingItem> getListOfSlots() {
        return listOfSlots;
    }
}
