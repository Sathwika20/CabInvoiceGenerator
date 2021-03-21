package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


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
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InVoiceGenerator inVoiceGenerator = new InVoiceGenerator();
        double fare = inVoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30.0, fare);
    }

}