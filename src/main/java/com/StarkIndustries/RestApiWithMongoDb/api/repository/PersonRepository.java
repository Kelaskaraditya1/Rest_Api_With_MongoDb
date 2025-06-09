package com.StarkIndustries.RestApiWithMongoDb.api.repository;

import com.StarkIndustries.RestApiWithMongoDb.api.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person,Long> {
}
