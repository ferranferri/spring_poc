package com.waynabox.springpoc.booking.infrastructure.controllers;

import com.waynabox.springpoc.booking.domain.BookingDatesList;
import com.waynabox.springpoc.booking.domain.service.BookingCaller;
import com.waynabox.springpoc.booking.domain.service.BookingCallerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class BookingControllerMulti {

    @RequestMapping(value = "/booking_multi", method = GET)
    public BookingDatesList makeBookingCallMulti() {
        BookingCaller bookingCaller = BookingCallerFactory.create(BookingCallerFactory.Strategy.MULTI_THREAD);
        return bookingCaller.exploreDates();
    }
}
