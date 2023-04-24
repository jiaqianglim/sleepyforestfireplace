package com.hype.webmvc.model;

import org.bson.Document;

public class TopicCard {

    private String avatarurl;
    private String title;
    private String subtitle;
    private String imageurl;
    private String content;

    public TopicCard fromDocument(Document doc) {
        return new TopicCard(doc.getString("avatarurl"), doc.getString("title"), doc.getString("subtitle"),
                doc.getString("imageurl"), doc.getString("content"));
    }

    /**
     * 
     */
    public TopicCard() {
    }

    /**
     * @param avatarurl
     * @param title
     * @param subtitle
     * @param imageurl
     * @param content
     */
    public TopicCard(String avatarurl, String title, String subtitle, String imageurl, String content) {
        this.avatarurl = avatarurl;
        this.title = title;
        this.subtitle = subtitle;
        this.imageurl = imageurl;
        this.content = content;
    }

    /**
     * @return the avatarurl
     */
    public String getAvatarurl() {
        return avatarurl;
    }

    /**
     * @param avatarurl the avatarurl to set
     */
    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle the subtitle to set
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * @return the imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl the imageurl to set
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
