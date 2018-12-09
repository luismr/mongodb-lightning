package com.aurea.cam.lightning.repository;

import com.aurea.cam.lightning.model.Organization;
import com.mongodb.client.result.UpdateResult;
import org.apache.http.util.Args;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class OrganizationRepositoryImpl implements OrganizationRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long update(Organization organization) {
        Args.notNull(organization, "Organization cannot be null!");
        Args.notNull(organization.getId(), "Organization Id cannot be null");
        Args.notEmpty(organization.getName(), "Organization Name cannot be empty");

        Query query = queryForOrganizationId(organization.getId());
        Update update = updateOrganization(organization);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Organization.class);

        long rows = 0;
        if (result != null) {
            rows = result.getModifiedCount();
        }

        return rows;
    }

    private Query queryForOrganizationId(ObjectId id) {
        return new Query(Criteria.where("id").is(id));
    }

    private Update updateOrganization(Organization organization) {
        Update update = new Update();
        update.set("parentId", organization.getParentId());
        update.set("name", organization.getName());
        update.set("uid", organization.getUid());
        return update;
    }
}
