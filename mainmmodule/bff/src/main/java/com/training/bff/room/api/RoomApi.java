package com.training.bff.room.api;

import com.training.bff.room.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ROOMSERVICES")
public interface RoomApi {

    @GetMapping(value = "/rooms")
    List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber);
}
