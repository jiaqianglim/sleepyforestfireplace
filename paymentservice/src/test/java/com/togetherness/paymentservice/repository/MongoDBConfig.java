package com.togetherness.paymentservice.repository;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

@Repository
public class MongoDBConfig {
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    MongoDatabase database = mongoClient.getDatabase("stripepayments");
    MongoCollection<Document> collection = database.getCollection("subscriptions");
}
