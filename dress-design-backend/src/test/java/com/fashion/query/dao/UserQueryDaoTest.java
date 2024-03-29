package com.fashion.query.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class UserQueryDaoTest {

	@Test
	void test(@Autowired MongoTemplate mongoTemplate) {
		DBObject objectToSave = BasicDBObjectBuilder.start().add("key", "value").get();

		// when
		mongoTemplate.save(objectToSave, "collection");

		// then
		assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key").containsOnly("value");
	}

}
