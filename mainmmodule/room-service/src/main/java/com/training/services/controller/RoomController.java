package com.training.services.controller;

import com.training.services.model.Room;
import com.training.services.services.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
@Api(value = "rooms", tags = ("rooms"))
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    @ApiOperation(value = "Get all rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> findAllByRoomNumber(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isNoneEmpty(roomNumber)) {
            return Collections.singletonList(this.roomService.findByRoomNumber(roomNumber));
        }
        return this.roomService.findAll();
    }
}
