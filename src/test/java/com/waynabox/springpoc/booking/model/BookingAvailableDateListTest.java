package com.waynabox.springpoc.booking.model;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
public class BookingAvailableDateListTest {
    private String jsonString1;
    private String jsonString2;

    @BeforeMethod
    public void setUp() throws Exception {
        jsonString1 = "{\"error\": false," +
                "\"dates\": " +
                "[\n" +
                "{\n" +
                "      \"id\": 1,\n" +
                "      \"from\": \"2016/06/24\",\n" +
                "      \"to\": \"2016/06/26\",\n" +
                "      \"avail\": false,\n" +
                "      \"level\" : 2,\n" +
                "      \"price\": 200\n" +
                "    }," +
                "{\n" +
                "      \"id\": 9,\n" +
                "      \"from\": \"2016/04/22\",\n" +
                "      \"to\": \"2016/04/24\",\n" +
                "      \"avail\": false,\n" +
                "      \"level\" : 2,\n" +
                "      \"price\": 200\n" +
                "    },        " +
                "\n]}";
        jsonString2 = "{\"error\": true}";
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testTheDepartureIdIsTheInsertedAsParameter() throws Exception {
        BookingPackItem bookingAvailableDateList = BookingPackItem.create(1, 2, "{}");
        Assert.assertEquals(bookingAvailableDateList.getDepartureId(), 1);
    }

    @Test
    public void testTheNumberOfDaysIsTheInsertedAsParameter() throws Exception {
        BookingPackItem bookingAvailableDateList = BookingPackItem.create(1, 2, "{}");
        Assert.assertEquals(bookingAvailableDateList.getNumberOfDays(), 2);
    }

    @Test
    public void testErrorIscorrectlyParsedFromJson() throws Exception {
        BookingPackItem bookingAvailableDateList = BookingPackItem.create(1, 2, jsonString1);
        Assert.assertEquals(bookingAvailableDateList.isError(), false);
        BookingPackItem bookingAvailableDateList2 = BookingPackItem.create(1, 2, jsonString2);
        Assert.assertEquals(bookingAvailableDateList2.isError(), true);
    }
}