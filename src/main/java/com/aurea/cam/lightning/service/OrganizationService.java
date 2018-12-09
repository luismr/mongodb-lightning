package com.aurea.cam.lightning.service;

import com.aurea.cam.lightning.model.Organization;
import com.aurea.cam.lightning.repository.OrganizationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization saveOrUpdate(final Organization organization) {
        Organization org = organizationRepository.save(organization);
        return org;
    }

    public Organization findById(final ObjectId id) {
        Optional<Organization> org = organizationRepository.findById(id);
        return (org != null) ? org.get() : null;
    }

    public Organization findByUid(final String uid) {
        Organization org = organizationRepository.findByUid(uid);
        return org;
    }

    public List<Organization > findByName(final String name) {
        String regex = String.format("%s*", name);
        List<Organization> orgs = organizationRepository.findByNameRegex(regex);
        return orgs;
    }

}
