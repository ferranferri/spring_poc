package com.waynabox.springpoc.booking.usecase;

import com.waynabox.springpoc.booking.model.BookingPackItem;
import com.waynabox.springpoc.booking.model.BookingDatesList;
import com.waynabox.springpoc.booking.service.BookingConnection;

/**
 * Make calls to booking one by one
 */
public class SingleThreadedBookingCaller extends BookingConnection {

    public BookingDatesList exploreDates() {
        BookingDatesList bookingDates = new BookingDatesList();
        for (int id : AVAILABLE_DEPARTURE_IDS) {
            for (int day : AVAILABLE_DAYS) {
                String result = makeCall(id, day);
                BookingPackItem bookingAvailableDateList = BookingPackItem.create(id, day, result);
                bookingDates.addBookingAvailableDateList(bookingAvailableDateList);
            }
        }
        bookingDates.stopTimer();
        return bookingDates;
    }

}
