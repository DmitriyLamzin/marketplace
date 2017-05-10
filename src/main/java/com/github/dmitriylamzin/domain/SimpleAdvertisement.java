package com.github.dmitriylamzin.domain;

import java.time.Duration;
import java.time.LocalDateTime;


public class SimpleAdvertisement implements Advertisement {
    private long startPrice;
    private long endPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public SimpleAdvertisement(long startPrice, long endPrice, LocalDateTime startTime, LocalDateTime endTime) {
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getActualPrice(LocalDateTime now) {
        double tangent = getTangent();
        long durationBetweenStartAndNow = Duration.between(startTime, now).toMillis() / 1000;
        return (long) (durationBetweenStartAndNow * tangent + startPrice);
    }

    private double getTangent() {
        double priceDiff = endPrice - startPrice;
        double duration = Duration.between(startTime, endTime).toMillis()/(1000);
        return priceDiff/duration;
    }

    public long getStartPrice() {
        return startPrice;
    }

    public long getEndPrice() {
        return endPrice;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getActualTime() {
        return LocalDateTime.now();
    }
}
