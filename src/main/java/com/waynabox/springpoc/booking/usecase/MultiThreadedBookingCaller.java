package com.waynabox.springpoc.booking.usecase;

import com.waynabox.springpoc.booking.model.BookingPackItem;
import com.waynabox.springpoc.booking.model.BookingDatesList;
import com.waynabox.springpoc.booking.service.BookingConnection;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 */
public class MultiThreadedBookingCaller extends BookingConnection {

    private final static Logger log = Logger.getLogger(MultiThreadedBookingCaller.class.getName());

    class SingleCallRunner extends BookingConnection implements Runnable {
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
            String result = makeCall(this.id, this.day);
            BookingPackItem bookingAvailableDateList = BookingPackItem.create(this.id, this.day, result);
            bookingDates.addBookingAvailableDateList(bookingAvailableDateList);
        }
    }
    public BookingDatesList exploreDates() {
        BookingDatesList bookingDates = new BookingDatesList();
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int id : AVAILABLE_DEPARTURE_IDS) {
            for (int day : AVAILABLE_DAYS) {
                SingleCallRunner singleCallRunner = new SingleCallRunner(day, id, bookingDates);
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
        bookingDates.stopTimer();
        return bookingDates;
    }
}
