package com.chulbul.hotelbooking.service.userservice.room;

import com.chulbul.hotelbooking.dto.req.RoomReqDto;
import com.chulbul.hotelbooking.dto.res.RoomDto;
import com.chulbul.hotelbooking.entity.Room;

import java.util.List;

public interface RoomService {

    //Add Room
    public RoomDto addRoom(RoomReqDto roomReqDto);

    //Get All the rooms
    public List<RoomDto> getAllRooms();

    //Get Room By id
    public RoomDto getRoomById(long id);

    //Update Room
    public RoomDto updateRoom(long id, RoomReqDto roomReqDto);

    //Delete
    public String deleteRoom(long id);

    //Find All rooms based on HotelId
    public List<RoomDto> getAllRoomsInHotel(long id);

}
