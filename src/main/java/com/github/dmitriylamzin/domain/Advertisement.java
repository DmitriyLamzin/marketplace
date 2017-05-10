package com.github.dmitriylamzin.domain;

import java.time.LocalDateTime;

/**
 * Created by Dmitriy on 08.05.2017.
 */
public interface Advertisement {

    long getActualPrice(LocalDateTime now);

    long getStartPrice();

    long getEndPrice();

    LocalDateTime getStartTime();

    LocalDateTime getEndTime();

    LocalDateTime getActualTime();


}
