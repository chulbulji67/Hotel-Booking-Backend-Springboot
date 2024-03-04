package com.chulbul.hotelbooking.service.userservice.room;

import com.chulbul.hotelbooking.dto.req.RoomReqDto;
import com.chulbul.hotelbooking.dto.res.RoomDto;
import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.Room;
import com.chulbul.hotelbooking.exception.hotelexception.HotelNotFoundException;
import com.chulbul.hotelbooking.exception.roomexception.RoomNotFoundException;
import com.chulbul.hotelbooking.repository.HotelReop;
import com.chulbul.hotelbooking.repository.RoomRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomImpl implements RoomService{

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelReop hotelReop;

    @Override
    public RoomDto addRoom(RoomReqDto roomReqDto) {
       Room room =  Room.builder()
                .roomNumber(roomReqDto.getRoomNumber())
                .roomType(roomReqDto.getRoomType())
                .roomStatus(roomReqDto.getRoomStatus())
                .price(roomReqDto.getPrice())
                .hotel(roomReqDto.getHotel()).build();
        roomRepo.save(room);

        return mapRoomToRoomDto(room);
    }



    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepo.findAll().stream().map(this::mapRoomToRoomDto).toList();
    }

    @Override
    public RoomDto getRoomById(long id) {
        Room room = roomRepo.findById(id).orElse(null);
        if(room == null) {
            throw new RoomNotFoundException("Room not found With id" + id);
        }
        return mapRoomToRoomDto(room);
    }

    @Override
    public RoomDto updateRoom(long id, RoomReqDto roomReqDto) {
        Room existingRoom = roomRepo.findById(id).orElse(null);
        if(existingRoom == null) {
            throw new RoomNotFoundException("Room not found With id" + id);
        }
        existingRoom.setRoomStatus(roomReqDto.getRoomStatus());
        existingRoom.setRoomType(roomReqDto.getRoomType());
        existingRoom.setPrice(roomReqDto.getPrice());
        roomRepo.save(existingRoom);
        return mapRoomToRoomDto(existingRoom);
    }

    @Override
    public String deleteRoom(long id) {
        Room existingRoom = roomRepo.findById(id).orElse(null);
        if(existingRoom == null) {
            throw new RoomNotFoundException("Room not found With id" + id);
        }
        roomRepo.deleteById(id);
        return "Room Deleted Successfully";
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(long id) {
        Hotel hotel = hotelReop.findById(id).orElse(null);
        if(hotel == null){
            throw new HotelNotFoundException("Hotel Not found With this Hotel Id "+id);
        }
        List<Room> roomsByHotel = roomRepo.findByHotel(hotel);

        log.info("rooms in Hotel {}",roomsByHotel.size());

        return roomsByHotel.stream().map(this::mapRoomToRoomDto).toList();
    }

    private RoomDto mapRoomToRoomDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .roomStatus(room.getRoomStatus())
                .price(room.getPrice()).build();
    }
}
