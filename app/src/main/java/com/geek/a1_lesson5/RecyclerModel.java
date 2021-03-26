package com.geek.a1_lesson5;

import java.io.Serializable;

public class RecyclerModel implements Serializable {
    private String title;
    private String sub_title;

    public RecyclerModel() {}

    public RecyclerModel(String title, String sub_title) {
        this.title = title;
        this.sub_title = sub_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }
}
