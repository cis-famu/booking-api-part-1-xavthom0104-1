package com.booking.booking.controller;
import com.booking.booking.model.Rooms;
import com.booking.booking.service.RoomsService;
import com.booking.booking.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/rooms")

public class RoomsController {
    private final RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRooms() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.getAllRooms(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }
    }

    @GetMapping("/{roomsId}")
    public ResponseEntity<ApiResponse> getRoomsbyId(@PathVariable String roomsId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", roomsService.getRoomsById(roomsId), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "An error occurred.", null, e.getMessage()));
        }

    }
}