package com.hype.webflux.WebsocketMessenging;

public class ChatroomMessage {
    private String user;
    private String messagecontent;

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

}
