package com.hype.webflux.WebsocketMessenging.Repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoDBReactive extends ReactiveMongoRepository<Object, String> {

}
