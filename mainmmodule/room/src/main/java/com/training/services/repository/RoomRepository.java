package com.training.services.repository;

import com.training.services.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Room findByRoomNumber(String roomNumber);
}
