package com.github.dmitriylamzin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class SimpleAdvertisement implements Advertisement {

    @Id
    @GeneratedValue
    private long id;

    private long startPrice;
    private long endPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public SimpleAdvertisement() {
    }

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

    @Transient
    private double getTangent() {
        double priceDiff = endPrice - startPrice;
        double duration = Duration.between(startTime, endTime).toMillis()/(1000);
        return priceDiff/duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(long startPrice) {
        this.startPrice = startPrice;
    }

    @Override
    public long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(long endPrice) {
        this.endPrice = endPrice;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Transient
    public LocalDateTime getActualTime() {
        return LocalDateTime.now();
    }
}
