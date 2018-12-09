package com.aurea.cam.lightning.repository;

import com.aurea.cam.lightning.model.MailingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MailingListRepository extends MongoRepository<MailingList, Long> {
}
