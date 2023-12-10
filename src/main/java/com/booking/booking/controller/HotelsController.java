package com.booking.booking.controller;
import com.booking.booking.model.Hotels;
import com.booking.booking.service.HotelsService;
import com.booking.booking.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/hotels")

public class HotelsController {
    private final HotelsService hotelsService;

    public HotelsController(HotelsService hotelsService){
        this.hotelsService = hotelsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllHotels(){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.getAllHotels(), null));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false,"An error occurred.", null, e.getMessage()));
        }
    }
    @GetMapping("/{hotelsId}")
    public ResponseEntity<ApiResponse> getHotelsbyId(@PathVariable String hotelsId){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", hotelsService.getHotelsById(hotelsId), null));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false,"An error occurred.", null, e.getMessage()));
        }

    }
}
