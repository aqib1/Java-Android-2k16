package com.evs.testapplication.sastabotique_local.test;

import com.evs.testapplication.sastabotique_local.topics.ListEntityBean;

/**
 * Created by AQIB JAVED on 9/15/2018.
 */

public class ListActivityEntityClass {
    private int imageSrc;
    private String title;

    public ListActivityEntityClass(int imageSrc,String title){
        this.imageSrc = imageSrc;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }
}
