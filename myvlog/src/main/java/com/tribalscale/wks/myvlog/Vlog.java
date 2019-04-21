package com.tribalscale.wks.myvlog;

public class Vlog {
    private final long id;
    private final String title;
    private final String url;
    private final long durationSeconds;

    public Vlog(){
        this.id = 0;
        this.title = "";
        this.url = null;
        this.durationSeconds = 0;
    }

    public Vlog(long id, String title, String url, long durationSeconds) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.durationSeconds = durationSeconds;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public long getDurationSeconds() {
        return durationSeconds;
    }
}
