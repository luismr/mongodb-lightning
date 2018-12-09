package com.aurea.cam.lightning.service;

import com.aurea.cam.lightning.model.Organization;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrganizationServiceTest {

    private static final String VALUE_TEMPLATE = "%s-%d";
    private static final String VALUE_TEMPLATE_NAME = "name";
    private static final String VALUE_TEMPLATE_UID = "uid";
    public static final int DEFAULT_PARENT_ID = -1;

    @Autowired
    private OrganizationService service;

    @Test
    public void saveOrUpdate() throws Exception {
        final long timestamp = System.currentTimeMillis();

        Organization o = new Organization();
        o.setName(String.format(VALUE_TEMPLATE, VALUE_TEMPLATE_NAME, timestamp));
        o.setUid(String.format(VALUE_TEMPLATE, VALUE_TEMPLATE_UID, timestamp));
        o.setParentId(DEFAULT_PARENT_ID);

        o = service.saveOrUpdate(o);

        assertNotNull(o);
        log.info(o.toString());
    }

    @Test
    public void findById() throws Exception {
        ObjectId id = new ObjectId("5bdf9ef81996a7cc87e95a62");
        Organization o = service.findById(id);
        assertNotNull(o);
        assertTrue(id.toString().equals(o.getId().toString()));
        log.info(o.toString());
    }

    @Test
    public void findByUid() throws Exception {
        Organization o = service.findByUid("uid");
        assertNotNull(o);
        assertTrue("uid".equals(o.getUid()));
        log.info(o.toString());
    }

    @Test
    public void findByName() throws Exception {
        List<Organization> organizations = service.findByName("nam");
        assertNotNull(organizations);
        assertFalse(organizations.isEmpty());
        organizations.forEach(o -> {
            log.info(o.toString());
        });
    }

}