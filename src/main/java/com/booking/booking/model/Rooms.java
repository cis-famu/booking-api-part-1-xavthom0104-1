package com.booking.booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Rooms extends ARooms {
    private	Hotels hotelID;

    public Rooms(@Nullable String roomID, String roomType, long price, long capacity, String description, String availability, ArrayList<String> images, Timestamp createdAt, Hotels hotelID) {
        super(roomID, roomType, price, capacity, description, availability, images, createdAt);
        this.hotelID = hotelID;
    }
}

