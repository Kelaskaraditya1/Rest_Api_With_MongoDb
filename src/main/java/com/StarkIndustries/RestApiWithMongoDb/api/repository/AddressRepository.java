package com.StarkIndustries.RestApiWithMongoDb.api.repository;

import com.StarkIndustries.RestApiWithMongoDb.api.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address,Long> {
}
