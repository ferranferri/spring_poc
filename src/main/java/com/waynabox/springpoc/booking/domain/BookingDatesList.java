package com.waynabox.springpoc.booking.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for booking dates
 */
public class BookingDatesList {
    private double timeTook;

    private transient long initialTime;
    private List<BookingPackItem> bookingPacks;

    public void addBookingAvailableDateList(BookingPackItem dateList) {
        bookingPacks.add(dateList);
    }

    public BookingDatesList() {
        bookingPacks = new ArrayList<>();
        initialTime = System.nanoTime();
        timeTook = 0;
    }

    public int getNumberOfCalls() {
        return bookingPacks.size();
    }

    public List<BookingPackItem> getBookingPacks() {
        return bookingPacks;
    }

    public void stopTimer() {
        timeTook = (System.nanoTime() - initialTime) / 1e6;
    }
    public double getTimeTook() {
        return timeTook;
    }
}
