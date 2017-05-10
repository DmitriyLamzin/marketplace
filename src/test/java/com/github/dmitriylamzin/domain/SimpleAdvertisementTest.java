package com.github.dmitriylamzin.domain;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;


public class SimpleAdvertisementTest {

    @Test
    public void shouldReturnActualPrice() {
        long expectedResult = 550;
        long startPrice = 1000;
        long endPrice = 100;
        LocalDateTime startTime = LocalDateTime.of(2017, Month.MAY, 1, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2017, Month.MAY, 1, 10, 0, 0);
        LocalDateTime now = LocalDateTime.of(2017, Month.MAY, 1, 5, 0, 0);
        SimpleAdvertisement simpleAdvertisement = new SimpleAdvertisement(startPrice, endPrice,
                startTime, endTime);
        long result = simpleAdvertisement.getActualPrice(now);
        assertEquals(expectedResult, result);
    }
}
