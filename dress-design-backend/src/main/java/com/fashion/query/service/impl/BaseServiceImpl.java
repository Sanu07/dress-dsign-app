package com.fashion.query.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
public class BaseServiceImpl {

	@Autowired
	MongoTemplate mongoTemplate;

	protected Boolean updateParticularField(Class<?> className, String id, String field1, String field2,
			String field2Value, Class<?> field2ValueType, String updateFieldName, Object updateValue,
			Class<?> updateValueType) {
		final Query query = new Query(new Criteria().andOperator(Criteria.where("_id").is(id),
				Criteria.where(field1).elemMatch(Criteria.where(field2).is(field2ValueType.cast(field2Value)))));
		final Update update = new Update().set(field1 + ".$." + updateFieldName, updateValueType.cast(updateValue));
		Boolean acknowledged = mongoTemplate.updateFirst(query, update, className).wasAcknowledged();
		return acknowledged;
	}

	protected Boolean updateMultipleObjects(Class<?> className, String fieldName, String fieldValue,
			Class<?> fieldValueType, String updateFieldName, Object updateValue, Class<?> updateValueType) {
		final Query query = new Query();
		query.addCriteria(Criteria.where(fieldName).is(fieldValueType.cast(fieldValue)));
		final Update update = new Update().set(updateFieldName, updateValueType.cast(updateValue));
		Boolean acknowledged = mongoTemplate.updateMulti(query, update, className).wasAcknowledged();
		return acknowledged;
	}
	
	protected Boolean updateSingleObject(Class<?> className, String id, String fieldName, Object fieldValue,
			Class<?> fieldValueType) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		final Update update = new Update().set(fieldName, fieldValueType.cast(fieldValue));
		Boolean acknowledged = mongoTemplate.updateMulti(query, update, className).wasAcknowledged();
		return acknowledged;
	}

}
