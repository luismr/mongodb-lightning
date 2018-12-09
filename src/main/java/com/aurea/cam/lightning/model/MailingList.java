package com.aurea.cam.lightning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString @EqualsAndHashCode
@Document(collection = MailingList.MONGODB_COLLECTION_NAME)
public class MailingList {
    public static final String MONGODB_COLLECTION_NAME = "lists";

    @Id
    private long id;

    @Indexed(unique = true)
    private long organizationId;

    @Indexed(unique = true)
    private String name;

    private String senderName;

    private String senderEmail;

}
