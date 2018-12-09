package com.aurea.cam.lightning.repository;

import com.aurea.cam.lightning.model.Organization;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrganizationRepository extends MongoRepository<Organization, ObjectId>, OrganizationRepositoryCustom {

    Organization findByUid(String uid);

    @Query("{name: { $regex: ?0 } }")
    List<Organization> findByNameRegex(String name);

}
