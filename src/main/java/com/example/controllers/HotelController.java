package com.example.controllers;

import com.example.entities.Hotel;
import com.example.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    public HotelService hotelService;
// http://localhost:8082/hotels
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> createHotel(@PathVariable String id){
        Hotel hotel1 = hotelService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel1);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> createHotel(){
        List<Hotel> all = hotelService.getAll();
        return ResponseEntity.ok(all);
    }
}