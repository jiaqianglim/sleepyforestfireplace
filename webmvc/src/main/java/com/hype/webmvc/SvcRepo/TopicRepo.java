package com.hype.webmvc.SvcRepo;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

public class TopicRepo {

    @Autowired
    MongoTemplate mongotemp;

    public List<Document> getTopicsBySearchTerm(String searchterm) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingPhrase(searchterm);
        TextQuery query = TextQuery.queryText(textCriteria);
        List<Document> results = mongotemp.find(query, Document.class, "topicdatabase");
        return results;
    }

    public Optional<Document> getTopicByName(String name) {
        Criteria criteria = Criteria.where("name").is("name");
        Query query = Query.query(criteria);
        Document result = mongotemp.findOne(query, Document.class, "topicdatabase");
        return Optional.of(result);
    }

    public Optional<Document> getTopicById(String id) {
        ObjectId objectId = new ObjectId(id);
        Document result = mongotemp.findById(objectId, Document.class, "topicdatabase");
        return Optional.of(result);
    }

    public void deleteByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        mongotemp.remove(query, Document.class, "topicdatabase");
    }

    public void insertDocuments(List<Document> docsToInsert) {
        mongotemp.insert(docsToInsert, "topicdatabase");
    }
}