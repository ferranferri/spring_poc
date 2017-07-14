package com.waynabox.springpoc.booking.usecase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test for SingleThreadedBookingCall
 */
public class SingleThreadedBookingCallerTest {
    @DataProvider
    public static Object[][] replacingUrl() {
        final String template = "https://waynabox.com/es/api/packs?departureId=%s&days=%s";
        return new Object[][] {
                {template, 3, 13, "https://waynabox.com/es/api/packs?departureId=13&days=3"},
                {template, 3, 18, "https://waynabox.com/es/api/packs?departureId=18&days=3"}
        };
    }

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test(dataProvider = "replacingUrl")
    public void testUrlComposer(String template, int day, int departureId, String expected) throws Exception {
        SingleThreadedBookingCaller singleThreadedBookingCaller = new SingleThreadedBookingCaller();
        String actualUrl = singleThreadedBookingCaller.urlComposer(template, departureId, day);
        Assert.assertEquals(actualUrl, expected);
    }

}