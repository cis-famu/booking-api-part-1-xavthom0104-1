package com.booking.booking.service;

import com.booking.booking.model.PaymentInformation;
import com.booking.booking.model.Users;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;
@Service
public class UsersService {
    private final Firestore firestore;

    public UsersService(){
        this.firestore = FirestoreClient.getFirestore();
    }
    public ArrayList<Users> getAllUsers()throws ExecutionException, InterruptedException {
        CollectionReference usersCollection = firestore.collection("Users");
        ApiFuture<QuerySnapshot> future = usersCollection.get();

        ArrayList<Users> userssList = new ArrayList<>();
        for(DocumentSnapshot document: future.get().getDocuments()){
            Users users = document.toObject(Users.class);
            if(users != null)
                userssList.add(users);
        }
        return userssList;

    }

    public Users getUsersById(String userID) throws ExecutionException, InterruptedException {
        CollectionReference userssCollection = firestore.collection("Users");
        ApiFuture<DocumentSnapshot> future = userssCollection.document(userID).get();
        DocumentSnapshot document = future.get();
        return document.toObject(Users.class);
    }
}

