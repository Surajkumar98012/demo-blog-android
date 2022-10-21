package com.example.demo_blog_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class blogWrapper {
    @SerializedName("data")
    @Expose
    private List<blog> data = null;

    public List<blog> getblogs() {
        return data;
    }

    public void setblogs(List<blog> data) {
        this.data = data;
    }
}
