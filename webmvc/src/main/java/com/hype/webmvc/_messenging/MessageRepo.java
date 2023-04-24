package com.hype.webmvc._messenging;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepo {
    @Autowired
    MongoTemplate mongotemp;

    public void save(Document doc) {
        mongotemp.insert(doc, "messages");
    }
}
