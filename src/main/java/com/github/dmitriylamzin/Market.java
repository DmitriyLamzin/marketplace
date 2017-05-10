package com.github.dmitriylamzin;

import com.github.dmitriylamzin.domain.Advertisement;

import java.util.List;

/**
 * Created by Dmitriy on 08.05.2017.
 */
public interface Market {

    void publishAnAdvertisement(Advertisement simpleAdvertisement);

    List<Advertisement> getAllAdvertisements();

    List<Advertisement> geAdvertisementsByPublisher();

}
