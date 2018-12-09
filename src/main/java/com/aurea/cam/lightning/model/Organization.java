package com.aurea.cam.lightning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode @ToString
@Document(collection = Organization.MONGODB_COLLECTION_NAME)
public class Organization {

    public static final String MONGODB_COLLECTION_NAME = "organizations";

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String uid;

    private String name;

    private long parentId;

}
