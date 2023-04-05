package com.togetherness.rsocketserver;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "messages")
public class Message {
    private String id = "asdf";
    private String body;

    /**
     * @param body
     * @param sentAt
     */
    public Message(String body) {
        this.body = body;
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

}
