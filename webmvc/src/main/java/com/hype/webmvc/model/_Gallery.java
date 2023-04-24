package com.hype.webmvc.model;

import java.util.List;

public class _Gallery {
    private String tabname;
    private List<String> imagelinks;

    /**
     * @return the tabname
     */
    public String getTabname() {
        return tabname;
    }

    /**
     * @param tabname the tabname to set
     */
    public void setTabname(String tabname) {
        this.tabname = tabname;
    }

    /**
     * @return the imagelinks
     */
    public List<String> getImagelinks() {
        return imagelinks;
    }

    /**
     * @param imagelinks the imagelinks to set
     */
    public void setImagelinks(List<String> imagelinks) {
        this.imagelinks = imagelinks;
    }

}
