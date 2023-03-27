package com.togetherness.rsocketserver;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "messages")
public class Message {
    private String id;
    private String body;
    private Instant sentAt;

    /**
     * @param body
     * @param sentAt
     */
    public Message(String body, Instant sentAt) {
        this.body = body;
        this.sentAt = sentAt;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the sentAt
     */
    public Instant getSentAt() {
        return sentAt;
    }

    /**
     * @param sentAt the sentAt to set
     */
    public void setSentAt(Instant sentAt) {
        this.sentAt = sentAt;
    }

}
