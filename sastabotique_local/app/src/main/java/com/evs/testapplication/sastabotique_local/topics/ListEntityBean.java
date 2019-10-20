package com.evs.testapplication.sastabotique_local.topics;

/**
 * Created by AQIB JAVED on 9/15/2018.
 */

public class ListEntityBean {
    private int imagesrc;
    private String title;
    public ListEntityBean(String title, int imagesrc){
        this.title = title;
        this.imagesrc = imagesrc;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(int imagesrc) {
        this.imagesrc = imagesrc;
    }
}
