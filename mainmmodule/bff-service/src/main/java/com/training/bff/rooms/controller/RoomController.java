package com.training.bff.rooms.controller;

import com.training.bff.rooms.api.RoomApi;
import com.training.bff.rooms.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomApi roomApi;

    @GetMapping(value = "/rooms")
    public List<Room> getAll(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        return roomApi.findAll(roomNumber);
    }
}