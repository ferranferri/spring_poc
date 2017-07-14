package com.waynabox.springpoc.booking.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for booking dates
 */
public class BookingDates {
    private int numberOfCalls;
    private int failedCalls;
    private int successfulCalls;
    private List<BookingAvailableDateList> bookingPacks;

    public void addBookingAvailableDateList(BookingAvailableDateList dateList) {
        bookingPacks.add(dateList);
    }

    public BookingDates() {
        numberOfCalls = 0;
        failedCalls = 0;
        successfulCalls = 0;
        bookingPacks = new ArrayList<>();
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public int getFailedCalls() {
        return failedCalls;
    }

    public int getSuccessfulCalls() {
        return successfulCalls;
    }

    public List<BookingAvailableDateList> getBookingPacks() {
        return bookingPacks;
    }
}
