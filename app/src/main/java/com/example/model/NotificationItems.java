package com.example.model;

public class NotificationItems {
    private int icon;
    private String title;
    private String content;
    private String time;

    public NotificationItems(int icon, String title, String content, String time) {
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
