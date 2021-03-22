package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;


public class InVoiceGeneratorTest {
    InVoiceGenerator InVoiceGenerator;

    @BeforeEach
    public void setUp(){
      InVoiceGenerator inVoiceGenerator  = new InVoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        InVoiceGenerator inVoiceGenerator = new InVoiceGenerator();
        double fare = inVoiceGenerator.calculateFare(distance, time);
        double diff = Math.abs(25 - fare);
        Assert.assertEquals(25.0, fare, diff);
    }

    @Test
    public void givenLessDistanceOfTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        InVoiceGenerator invoiceGenerator = new InVoiceGenerator();
        double fare = invoiceGenerator.calculateFare(distance, time);
        double diff = Math.abs(5 - fare);
        Assert.assertEquals(5,fare, diff);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary actualInvoiceSummary = InVoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }
    @Test
    public void getUserRideSummaryTest() {
        ArrayList<InvoiceSummary> expectedSummery = new ArrayList<>();
        Ride[] rides1 = new Ride[]{new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = InVoiceGenerator.calculateFare(rides1);
        expectedSummery.add(summary);
        Ride[] rides2 = {new Ride(2.0, 5),
                new Ride(0.3, 1)
        };
        summary = InVoiceGenerator.calculateFare(rides2);
        expectedSummery.add(summary);
        Assert.assertEquals(expectedSummery, RideRepository.getUserRideList(5));
    }

}