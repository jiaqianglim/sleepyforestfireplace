package com.hype.webmvc.model;

import java.util.List;

public class Topic {

    private String name;
    private String avatarurl;
    private String title;
    private String subtitle;
    private String imageurl;
    private String content;
    private List<_Map> maps;
    private List<_Info> infos;
    private List<_Gallery> gallerys;
    private List<_Chat> chats;

    public Topic() {
    };

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the maps
     */
    public List<_Map> getMaps() {
        return maps;
    }

    /**
     * @param maps the maps to set
     */
    public void setMaps(List<_Map> maps) {
        this.maps = maps;
    }

    /**
     * @return the infos
     */
    public List<_Info> getInfos() {
        return infos;
    }

    /**
     * @param infos the infos to set
     */
    public void setInfos(List<_Info> infos) {
        this.infos = infos;
    }

    /**
     * @return the gallerys
     */
    public List<_Gallery> getGallerys() {
        return gallerys;
    }

    /**
     * @param gallerys the gallerys to set
     */
    public void setGallerys(List<_Gallery> gallerys) {
        this.gallerys = gallerys;
    }

    /**
     * @return the chats
     */
    public List<_Chat> getChats() {
        return chats;
    }

    /**
     * @param chats the chats to set
     */
    public void setChats(List<_Chat> chats) {
        this.chats = chats;
    }

}
