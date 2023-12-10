package com.booking.booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.protobuf.util.Timestamps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @DocumentId
    private @Nullable String userID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private PaymentInformation paymentInformation;
    private @Nullable Timestamp createdAt;
}