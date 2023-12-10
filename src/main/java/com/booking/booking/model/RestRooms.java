package com.booking.booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class RestRooms extends ARooms{
    private DocumentReference hotelID;

    public RestRooms(@Nullable String roomID, String roomType, long price, long capacity, String description, String availability, ArrayList<String> images, Timestamp createdAt, DocumentReference hotelID) {
        super(roomID, roomType, price, capacity, description, availability, images, createdAt);
        this.hotelID = hotelID;
    }

    public void setHotelID(String hotelID){
        Firestore firestore = FirestoreClient.getFirestore();
        this.hotelID = firestore.collection("Rooms").document(hotelID);
    }
}
