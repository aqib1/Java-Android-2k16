package com.evs.testapplication.evsandroid_batch36;

/**
 * Created by AQIB JAVED on 12/9/2018.
 */

public class SettingBean {
    private String title;
    private String subTitle;
    private int imageSrc;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }
}
