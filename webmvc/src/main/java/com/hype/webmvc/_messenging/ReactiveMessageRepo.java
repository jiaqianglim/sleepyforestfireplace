package com.hype.webmvc._messenging;

import org.bson.conversions.Bson;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveMessageRepo extends ReactiveMongoRepository<Bson, String> {

}
