package com.waynabox.springpoc.booking.domain.service;

import com.waynabox.springpoc.booking.domain.BookingDatesList;
import com.waynabox.springpoc.booking.domain.BookingPackItem;
import org.springframework.web.client.RestTemplate;

/**
 * Make calls to booking one by one
 */
public class SingleThreadedBookingCaller implements BookingCaller {
    private int[] departureIds;
    private int[] days;
    private String url_template;

    /**
     * Avoid creation other than going through factory.
     */
    private SingleThreadedBookingCaller() { }


    static SingleThreadedBookingCaller create(final String url_template, final int[] departureIds, final int[] days) {
        SingleThreadedBookingCaller singleThreadedBookingCaller = new SingleThreadedBookingCaller();
        singleThreadedBookingCaller.url_template = url_template;
        singleThreadedBookingCaller.departureIds = departureIds;
        singleThreadedBookingCaller.days = days;
        return singleThreadedBookingCaller;
    }

    @Override
    public BookingDatesList exploreDates() {
        BookingDatesList bookingDates = new BookingDatesList();
        for (int id : departureIds) {
            for (int day : days) {
                final String url = String.format(url_template, id, day);
                RestTemplate restTemplate = new RestTemplate();
                BookingPackItem bookingPackItem = restTemplate.getForObject(url, BookingPackItem.class);
                bookingPackItem.setDepartureId(id);
                bookingPackItem.setNumberOfDays(day);
                bookingDates.addBookingAvailableDateList(bookingPackItem);
            }
        }
        bookingDates.stopTimer();
        return bookingDates;
    }
}
