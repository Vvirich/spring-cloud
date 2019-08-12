package com.training.services.services;

import com.training.services.model.Room;

import java.util.List;

public interface RoomService {

    Room findByRoomNumber(String roomNumber);

    List<Room> findAll();
}
