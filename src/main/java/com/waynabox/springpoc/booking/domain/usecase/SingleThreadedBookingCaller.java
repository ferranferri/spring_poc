package com.waynabox.springpoc.booking.domain.usecase;

import com.waynabox.springpoc.booking.domain.BookingPackItem;
import com.waynabox.springpoc.booking.domain.BookingDatesList;
import com.waynabox.springpoc.booking.domain.service.BookingConnection;
import org.springframework.web.client.RestTemplate;

/**
 * Make calls to booking one by one
 */
public class SingleThreadedBookingCaller extends BookingConnection {

    public BookingDatesList exploreDates() {
        BookingDatesList bookingDates = new BookingDatesList();
        for (int id : AVAILABLE_DEPARTURE_IDS) {
            for (int day : AVAILABLE_DAYS) {
                RestTemplate restTemplate = new RestTemplate();
                BookingPackItem bookingPackItem = restTemplate.getForObject(getUrl(id, day), BookingPackItem.class);
                bookingPackItem.setDepartureId(id);
                bookingPackItem.setNumberOfDays(day);
                bookingDates.addBookingAvailableDateList(bookingPackItem);
            }
        }
        bookingDates.stopTimer();
        return bookingDates;
    }

    /**
     * @// TODO: 7/18/17 refactor that piece of shit
     * @param id
     * @param day
     * @return
     */
    private String getUrl(int id, int day) {
        return urlComposer(URL_CALL, id, day);
    }

}
