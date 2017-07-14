package com.waynabox.springpoc.booking.controller;

import com.waynabox.springpoc.booking.model.BookingDates;
import com.waynabox.springpoc.booking.usecase.SingleThreadedBookingCaller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Booking controller
 */
@RestController
public class BokingController {

    @RequestMapping(value = "/booking", method = GET)
    public BookingDates makeBookingCall() {
        return new SingleThreadedBookingCaller().exploreDates();
    }
}
