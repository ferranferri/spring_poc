package com.waynabox.springpoc.booking.domain.service;

import com.waynabox.springpoc.booking.domain.BookingPackItem;
import com.waynabox.springpoc.booking.domain.BookingDatesList;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 */
public class MultiThreadedBookingCaller implements BookingCaller {
    private final static Logger log = Logger.getLogger(MultiThreadedBookingCaller.class.getName());

    private int[] departureIds;
    private int[] days;
    private String url_template;

    /**
     * Avoid creation
     */
    private MultiThreadedBookingCaller() {}

    static MultiThreadedBookingCaller create(final String url_template, final int[] departureIds, final int[] days) {
        MultiThreadedBookingCaller multiThreadedBookingCaller = new MultiThreadedBookingCaller();
        multiThreadedBookingCaller.url_template = url_template;
        multiThreadedBookingCaller.departureIds = departureIds;
        multiThreadedBookingCaller.days = days;
        return multiThreadedBookingCaller;
    }

    class SingleCallRunner implements Runnable {
        int day;
        int id;
        BookingDatesList bookingDates;

        SingleCallRunner(int day, int id, BookingDatesList bookingDates) {
            this.day = day;
            this.id = id;
            this.bookingDates = bookingDates;
        }

        @Override
        public void run() {
            final String url = String.format(url_template, this.id, this.day);
            RestTemplate restTemplate = new RestTemplate();
            BookingPackItem bookingPackItem = restTemplate.getForObject(url, BookingPackItem.class);
            bookingPackItem.setDepartureId(id);
            bookingPackItem.setNumberOfDays(day);
            bookingDates.addBookingAvailableDateList(bookingPackItem);
        }
    }



    public BookingDatesList exploreDates() {
        BookingDatesList bookingDatesList = new BookingDatesList();
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int id : departureIds) {
            for (int day : days) {
                SingleCallRunner singleCallRunner = new SingleCallRunner(day, id, bookingDatesList);
                Thread thread = new Thread(singleCallRunner);
                threadArrayList.add(thread);
                thread.start();
            }
        }
        for (Thread t : threadArrayList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                log.severe(ExceptionUtils.getStackTrace(e));
                t.interrupt();
            }
        }
        bookingDatesList.stopTimer();
        return bookingDatesList;
    }
}
