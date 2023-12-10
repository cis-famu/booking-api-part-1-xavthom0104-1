package com.booking.booking.controller;
import com.booking.booking.model.Users;
import com.booking.booking.service.UsersService;
import com.booking.booking.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")

public class UsersController {
    private UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers(){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", usersService.getAllUsers(), null));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false,"An error occurred.", null, e.getMessage()));
        }
    }
    @GetMapping("/{usersId}")
    public ResponseEntity<ApiResponse> getUsersbyId(@PathVariable String usersId){
        try{
            return ResponseEntity.ok(new ApiResponse(true, "Success", usersService.getUsersById(usersId), null));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse(false,"An error occurred.", null, e.getMessage()));
        }

    }

}
