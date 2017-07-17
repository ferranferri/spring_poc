package com.waynabox.springpoc.booking.controller;

import com.waynabox.springpoc.booking.model.BookingDatesList;
import com.waynabox.springpoc.booking.usecase.MultiThreadedBookingCaller;
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
    public BookingDatesList makeBookingCall() {
        return new SingleThreadedBookingCaller().exploreDates();
    }

    @RequestMapping(value = "/booking_multi", method = GET)
    public BookingDatesList makeBookingCallMulti() {
        return new MultiThreadedBookingCaller().exploreDates();
    }
}
