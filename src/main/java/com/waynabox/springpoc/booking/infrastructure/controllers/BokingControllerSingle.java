package com.waynabox.springpoc.booking.infrastructure.controllers;

import com.waynabox.springpoc.booking.domain.BookingDatesList;
import com.waynabox.springpoc.booking.domain.service.BookingCaller;
import com.waynabox.springpoc.booking.domain.service.BookingCallerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Booking controller
 */
@RestController
public class BokingControllerSingle {

    @RequestMapping(value = "/booking", method = GET)
    public BookingDatesList makeBookingCall() {
        BookingCaller bookingCaller = BookingCallerFactory.create(BookingCallerFactory.Strategy.SINGLE_THREAD);
        return bookingCaller.exploreDates();
    }

}
