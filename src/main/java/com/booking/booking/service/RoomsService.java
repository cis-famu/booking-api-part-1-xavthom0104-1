package com.booking.booking.service;
import com.booking.booking.model.Hotels;
import com.booking.booking.model.Rooms;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@Service
public class RoomsService {
    private Firestore firestore;
    private Logger logger;

    public RoomsService() {
        this.firestore = FirestoreClient.getFirestore();

    }

    private Rooms documentSnapshotToRoom(DocumentSnapshot document) throws ExecutionException, InterruptedException {
        Rooms room = null;
        if (document.exists()) {
            System.out.println("exists");
            ArrayList<String> images = (ArrayList<String>) document.get("images");
            DocumentReference hotelRef = (DocumentReference) document.get("hotelID");
            Hotels hotel = null;
            if (hotelRef != null) {
                try {
                    System.out.println("hotel got");
                    ApiFuture<DocumentSnapshot> future = hotelRef.get();
                    DocumentSnapshot snap = future.get();
                    if (snap.exists()) {
                        hotel = snap.toObject(Hotels.class);
                    } else {
                        System.out.println("Hotel document does not exist.");
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            room = new Rooms(document.getId(),
                    document.getString("roomType"),
                    document.getLong("price"),
                    document.getLong("capacity"),
                    document.getString("description"),
                    document.getString("availability"),
                    images,
                    document.getTimestamp("createdAt"),
                    hotel);
        }
        return room;
    }

    public ArrayList<Rooms> getAllRooms() throws ExecutionException, InterruptedException {
        CollectionReference roomsCollection = firestore.collection("Rooms");
        ApiFuture<QuerySnapshot> future = roomsCollection.get();

        ArrayList<Rooms> roomsList = new ArrayList<>();

        for(DocumentSnapshot document: future.get().getDocuments())
        {
            Rooms rooms = documentSnapshotToRoom(document);
            System.out.println(rooms);
            if(rooms != null)
                roomsList.add(rooms);
        }
        return roomsList;

    }
    public Rooms getRoomsById(String roomID) throws ExecutionException, InterruptedException {
        CollectionReference bookingsCollection = firestore.collection("Rooms");
        ApiFuture<DocumentSnapshot> future = bookingsCollection.document(roomID).get();
        DocumentSnapshot document = future.get();
        return documentSnapshotToRoom(document);
    }
}
