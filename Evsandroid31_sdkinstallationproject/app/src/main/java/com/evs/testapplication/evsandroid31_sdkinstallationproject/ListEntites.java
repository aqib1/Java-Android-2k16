package com.evs.testapplication.evsandroid31_sdkinstallationproject;

/**
 * Created by AQIB JAVED on 10/6/2018.
 */

public class ListEntites {
    private int imageSrc;
    private String title;

    public ListEntites(int imageSrc, String title){
        this.imageSrc = imageSrc;
        this.title = title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }
}
