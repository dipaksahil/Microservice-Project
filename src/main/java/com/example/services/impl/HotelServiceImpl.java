package com.example.services.impl;

import com.example.exception.ResourceNotFoundException;
import com.example.entities.Hotel;
import com.example.repositories.HotelRepository;
import com.example.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("hotel with given id not found!!")
        );
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> all = hotelRepository.findAll();
        return all;
    }
}
