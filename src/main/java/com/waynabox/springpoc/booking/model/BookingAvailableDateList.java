package com.waynabox.springpoc.booking.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The result of a pack call
 */
public class BookingAvailableDateList {
    private int departureId;
    private int numberOfDays;

    @SerializedName("error")
    private boolean error;

    @SerializedName("dates")
    List<BookingItem> listOfSlots;

    static BookingAvailableDateList create(int departureId, int numberOfDays, String jsonResponse) {
        Gson gson = new Gson();
        BookingAvailableDateList bookingAvailableDateList = gson.fromJson(jsonResponse, BookingAvailableDateList.class);
        bookingAvailableDateList.departureId = departureId;
        bookingAvailableDateList.numberOfDays = numberOfDays;
        return bookingAvailableDateList;
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
