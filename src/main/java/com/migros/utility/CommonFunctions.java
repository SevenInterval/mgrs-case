package com.migros.utility;

import com.migros.dto.CourierDto;
import com.migros.dto.StoreDto;
import com.migros.model.Courier;
import com.migros.model.Store;
import org.springframework.stereotype.Component;

@Component
public class CommonFunctions {

    public double findDistanceMeter(Courier courier, Store store) {
        // This info coming from: https://dzone.com/articles/distance-calculation-using-3
        double courierLat = courier.getLat();
        double courierLng = courier.getLng();
        double storeLat = store.getLat();
        double storeLng = store.getLng();

        double theta = courierLng - storeLng;
        double dist = Math.sin(deg2rad(courierLat)) * Math.sin(deg2rad(storeLat)) + Math.cos(deg2rad(courierLat)) * Math.cos(deg2rad(storeLat)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; // Unit is KM
        dist = dist * 1000; // Unit is M
        return (dist);
    }

    public double findDistanceOfCourier(CourierDto courierDto, Courier courier) {
        // This info coming from: https://dzone.com/articles/distance-calculation-using-3
        double courierLat = courierDto.getGeolocation().getLat();
        double courierLng = courierDto.getGeolocation().getLng();
        double courierLastLat = courier.getLat();
        double courierLastLng = courier.getLng();

        double theta = courierLng - courierLastLng;
        double dist = Math.sin(deg2rad(courierLat)) * Math.sin(deg2rad(courierLastLat)) + Math.cos(deg2rad(courierLat)) * Math.cos(deg2rad(courierLastLat)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; // Unit is KM
        dist = dist * 1000; // Unit is M
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
