package com.example.services;

import com.example.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    Hotel get(String id);
    List<Hotel> getAll();
}
