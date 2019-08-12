package com.training.services.services.impl;

import com.training.services.model.Room;
import com.training.services.repository.RoomRepository;
import com.training.services.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findByRoomNumber(String roomNumber) {
        return this.roomRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> findAll() {
        return (List<Room>) this.roomRepository.findAll();
    }
}
