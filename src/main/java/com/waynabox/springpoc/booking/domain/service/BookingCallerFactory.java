package com.waynabox.springpoc.booking.domain.service;

/**
 *
 */
public class BookingCallerFactory {
    public enum Strategy {
        SINGLE_THREAD,
        MULTI_THREAD
    }

    public static BookingCaller create(final Strategy strategy) {
        final String URL_CALL = "https://waynabox.com/es/api/packs?departureId=%s&days=%s";

        final int[] AVAILABLE_DAYS = {3, 5};
        final int[] AVAILABLE_DEPARTURE_IDS = {3, 13, 15, 16, 29, 31, 64};

        switch (strategy) {
            case MULTI_THREAD:
                return MultiThreadedBookingCaller.create(URL_CALL, AVAILABLE_DEPARTURE_IDS, AVAILABLE_DAYS);
            case SINGLE_THREAD:
                return SingleThreadedBookingCaller.create(URL_CALL, AVAILABLE_DEPARTURE_IDS, AVAILABLE_DAYS);
            default:
                throw new RuntimeException("You mustn't be here");

        }
    }
}
