package com.training.bff.rooms.api;

import com.training.bff.rooms.model.Room;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ROOMSERVICES")
public interface RoomApi {

    @GetMapping(value = "/rooms")
    List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber);
}
