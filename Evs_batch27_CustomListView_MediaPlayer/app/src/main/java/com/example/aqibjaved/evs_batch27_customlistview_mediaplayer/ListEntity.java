package com.example.aqibjaved.evs_batch27_customlistview_mediaplayer;

/**
 * Created by AQIB JAVED on 3/24/2018.
 */

public class ListEntity {
    private int id;
    private String title;

    public ListEntity() {
    }

    public ListEntity(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
