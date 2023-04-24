package com.hype.webmvc.model;

import java.util.HashMap;

public class _Info {

    private String tabname;
    private HashMap<String, String> sections;

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
     * @return the sections
     */
    public HashMap<String, String> getSections() {
        return sections;
    }

    /**
     * @param sections the sections to set
     */
    public void setSections(HashMap<String, String> sections) {
        this.sections = sections;
    }

}
