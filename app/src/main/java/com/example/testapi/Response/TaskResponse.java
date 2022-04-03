package com.example.testapi.Response;

import com.google.gson.annotations.SerializedName;

public class TaskResponse {
    @SerializedName("activity")
    private String activity;
    @SerializedName("accessibility")
    private double accessibility;
    @SerializedName("link")
    private String link;

    public TaskResponse(String activity, double accessibility, String link) {
        this.activity = activity;
        this.accessibility = accessibility;
        this.link = link;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(double accessibility) {
        this.accessibility = accessibility;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
