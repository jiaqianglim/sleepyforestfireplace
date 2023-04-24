package com.hype.webmvc._messenging;

import java.time.LocalDate;

public class ChatroomDocument {
    private String user;
    private String messagecontent;
    private LocalDate date;
    private String topic;

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the messagecontent
     */
    public String getMessagecontent() {
        return messagecontent;
    }

    /**
     * @param messagecontent the messagecontent to set
     */
    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

}
