package com.booking.booking.model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ARooms {
    @DocumentId
    protected @Nullable String roomID;
    protected String roomType;
    protected long price;
    protected long capacity;
    protected String description;
    protected String availability;
    protected ArrayList<String> images;
    protected Timestamp createdAt;
}
